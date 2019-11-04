import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavascriptTest
{
    public static void main(String[] args) throws Exception
    {
        String file = args[0];
        String name = (args.length > 1) ? args[1] : "JavaScript";
        try {
            // The ScriptEngine is single use (at least for now).
            // A new ScriptEngine is used for each script.
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine jsEngine = manager.getEngineByName( name );

            String script = "load(\"" + file + "\");";
            
            long t = System.currentTimeMillis();
            jsEngine.eval(script);
            t = System.currentTimeMillis() - t;
            System.out.println(t);
            
        } catch (ScriptException e) {
            throw e;
        }
    }
}
