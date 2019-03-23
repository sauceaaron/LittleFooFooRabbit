import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GoodFairy
{

	public static class ConsequenceException extends GoodFairyException{
	}

	public static class WarningException extends GoodFairyException
	{
		@Override
		public String getMessage()
		{
			StackTraceElement element = getStackTrace()[0];
			String who = element.getClassName() + " " + element.getClassName();
			FieldMouse[] victims = new FieldMouse[3];
			String what = element.getMethodName();
			String where = FieldMouse.class.getFields()[0].getName();

			return "Little bunny " + who +  " " +
					"I don't want to see you " +
					"scoopUp() "  + victims.getClass().getName() + " and "
					+ what + "() the " + where;

		}
	}
}
