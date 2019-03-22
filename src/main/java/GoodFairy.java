public class GoodFairy
{

	public static class ConsequenceException extends GoodFairyException{
	}

	public static class WarningException extends GoodFairyException
	{
		@Override
		public String getMessage()
		{
			return "I don't want to see you...";
		}
	}
}
