/*
 * Druid - a distributed column store.
 * Copyright 2012 - 2015 Metamarkets Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.druid.server.coordinator.rules;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 */
public class RuleMap
{
  private final Map<String, List<Rule>> rules;
  private final List<Rule> defaultRules;

  public RuleMap(Map<String, List<Rule>> rules, List<Rule> defaultRules)
  {
    this.rules = rules;
    this.defaultRules = defaultRules;
  }

  public List<Rule> getRules(String dataSource)
  {
    List<Rule> retVal = Lists.newArrayList();
    if (dataSource != null) {
      retVal.addAll(rules.get(dataSource));
    }
    if (defaultRules != null) {
      retVal.addAll(defaultRules);
    }
    return retVal;
  }
}
