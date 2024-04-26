package utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStepStarted;

public class StepDetails implements ConcurrentEventListener {

    public static String keyword;
    public static String name;
    private EventHandler<TestStepStarted> handler = this::logTestStepName;

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class, handler);
    }

    private void logTestStepName(TestStepStarted testStepStarted) {
        if(testStepStarted.getTestStep() != null && testStepStarted.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) testStepStarted.getTestStep();
            keyword = testStep.getStep().getKeyword();
            name = testStep.getStep().getText();
        }
    }
}
