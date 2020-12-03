package by.testing.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.testing.controller.command.impl.*;

public class CommandProvider {
	private Map<String, Command> commands;
	
	public CommandProvider() {
		commands = new HashMap<String, Command>();
		commands.put("log_in", new LoginationCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("sign_out", new SignOutCommand());
		commands.put("add_test", new AddTestCommand());
		commands.put("go_to_registration", new GoToRegistrationCommand());
		commands.put("go_to_logination", new GoToLoginationCommand());
		commands.put("go_to_testconstructor", new GoToTestConstructorCommand());
		commands.put("go_to_question_constructor", new GoToQuestionConstructorCommand());
		commands.put("add_question", new AddQuestionCommand());
		commands.put("edit_test", new EditTestCommand());
		commands.put("change_locale", new ChangeLocalCommand());
		commands.put("start_test", new StartTestCommand());
		commands.put("go_to_next_question", new NextQuestionCommand());
		commands.put("go_to_student_main", new GoToStudentMainCommand());
		commands.put("delete_test", new DeleteTestCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
