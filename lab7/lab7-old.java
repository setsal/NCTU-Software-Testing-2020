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

    @Given("dividend")
    public void dividend() {
        this.dividend = 6.0;
    }

    @Given("divisor")
    public void divisor() {
        this.divisor = 2.0;
    }

    @When("I ask what's the answer for divider")
    public void i_ask_what_s_the_answer_for_divider() {
        try {
            this.answer = Divider.divide( this.dividend, this.divisor );
        } catch ( ArithmeticException e ) {
            this.flag = 1;
        }
    }

    @Then("I should get the answer for divider")
    public void i_should_get_the_answer_for_divider() {
        // Write code here that turns the phrase above into concrete actions
        double expectValue = 3.0;
        assertEquals( expectValue, this.answer, 0.001 );
    }

    @Given("divisor zero")
    public void divisor_zero() {
        this.divisor = 0.0;
    }

    @Then("I should get the exception for divider")
    public void i_should_get_the_exception_for_divider() {
        assertEquals( 1, this.flag );
    }


}
