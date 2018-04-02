package com.jpmorgan.cakeshop.conditions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @author Michael Kazansky
 */
public class AbsentDataBaseConditon extends BaseCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (StringUtils.isBlank(databaseName)) {
            databaseName = context.getEnvironment().getProperty("cakeshop.database.vendor");
        }
        return StringUtils.isBlank(databaseName);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return null;
    }

}
