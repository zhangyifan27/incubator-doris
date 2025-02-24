// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.rules;

import org.apache.doris.nereids.CascadesContext;
import org.apache.doris.nereids.exceptions.TransformException;
import org.apache.doris.nereids.pattern.Pattern;
import org.apache.doris.nereids.trees.plans.Plan;

import java.util.List;
import java.util.Objects;

/** ProxyRule */
public class ProxyRule extends Rule {
    protected final Rule rule;

    public ProxyRule(Rule rule) {
        this(rule, rule.getRuleType(), rule.getPattern(), rule.getRulePromise());
    }

    public ProxyRule(Rule rule, RuleType ruleType, Pattern pattern, RulePromise rulePromise) {
        super(ruleType, pattern, rulePromise);
        this.rule = Objects.requireNonNull(rule, "rule cannot be null");
    }

    @Override
    public List<Plan> transform(Plan node, CascadesContext context) throws TransformException {
        return rule.transform(node, context);
    }
}
