package lambdas;
@FunctionalInterface
public interface Command {
  void execute(String argument);
}
