package Stepdefinitions;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("featurefiles/login.feature")
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "Stepdefinitions"
)
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty, html:target/cucumber-reports/login-report.html"
)
public class TestRunner {
}