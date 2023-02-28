package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping()
    public String getWelcomeMathMsg() {
        return "Welcome from MathController";
    }

    @GetMapping("/division-info")
    public ArithmeticOperation division() {
        String[] properties = {"Divisione per 0, Divisione per 1"};
        return new ArithmeticOperation(
                "Division ",
                0,
                "Dividendo/Divisore = Divisione ",
                properties);
    }

    @GetMapping(value = "/multiplication")
    public int getMultiplication(
            @RequestParam(required = true) int operand1,
            @RequestParam(required = true) int operand2) {
        return operand1 * operand2;
    }

    @GetMapping(value = "/square/{n}")
    @ApiOperation(value = "Execute a square of a given number", notes = "Gives back to the user the result of multiplication of the given number times itself")
    public int getSquare(@ApiParam(value = "The number that need to be squared") @PathVariable() int n){
        return n * n;
    }
}
