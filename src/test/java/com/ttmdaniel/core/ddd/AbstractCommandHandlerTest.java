package com.ttmdaniel.core.ddd;

import com.ttmdaniel.core.patterns.AbstractConverter;
import org.junit.Before;
import org.junit.Test;

public class AbstractCommandHandlerTest {

    private RegisterNewUserCommandHandler abstractCommandHandler ;


    @Before
    public void setUp() {
        abstractCommandHandler = new RegisterNewUserCommandHandler() ;
    }

    @Test
    public void testCommandHandler() {
        RegisterNewUserCommandResult result = abstractCommandHandler.handle(new RegisterNewUserCommand()) ;

        new RegisterNewUserCommandResultToResponseConverter().convert(result);
    }


    public static class RegisterNewUserCommandHandler
            implements AbstractCommandHandler<RegisterNewUserCommand,  RegisterNewUserCommandResult> {

        @Override
        public RegisterNewUserCommandResult handle(RegisterNewUserCommand command) {
            return null;
        }
    }

    public static class RegisterNewUserCommand extends AbstractCommand {

        private String id ;

        public String getId() {
            return id ;
        }
    }

    public static class RegisterNewUserCommandResult extends AbstractResult<RegisterNewUserCommand> {

        public RegisterNewUserCommandResult(RegisterNewUserCommand command) {
            super(command);
        }
    }

    static class RegisterNewUserCommandResultToResponseConverter
            implements AbstractConverter<RegisterNewUserCommandResult, Response> {

        @Override
        public Response convert(RegisterNewUserCommandResult object) {
            return null;
        }
    }

    static class Response {

    }

}
