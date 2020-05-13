package lab7;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs {

    private double dividend;
    private double divisor;
    private double answer;
    private int flag = 0;

    @Given("dividend is {double}")
    public void dividend_is(double dividend) {
        // Write code here that turns the phrase above into concrete actions
        this.dividend = dividend;
    }

    @Given("divisor is {double}")
    public void divisor_is(double divisor) {
        // Write code here that turns the phrase above into concrete actions
        this.divisor = divisor;
    }


    @When("I ask what's the answer for divider")
    public void i_ask_what_s_the_answer_for_divider() {
        try {
            this.answer = Divider.divide( this.dividend, this.divisor );
        } catch ( ArithmeticException e ) {
            this.flag = 1;
        }
    }

    @Then("I should get the answer {double} for divider")
    public void i_should_get_the_answer_for_divider(double expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(this.answer, expectedAnswer, 0.001);
    }

    @Then("I should get the exception for divider")
    public void i_should_get_the_exception_for_divider() {
        assertEquals( 1, this.flag );
    }


}
