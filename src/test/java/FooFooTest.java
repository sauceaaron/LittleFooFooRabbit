import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class FooFooTest
{
	@Test(expected = GoodFairy.WarningException.class)
	public void shouldBeGivenWarningOnFirstTry() throws GoodFairyException
	{
		Foo foo = Rabbit.Instance(Size.little);
		foo.scoopUp(new FieldMouse()).bopOn(FieldMouse.head);
	}

	@Test
	public void shouldBeGivenWarningOnSecondTry() throws GoodFairyException
	{
		Foo foo = Rabbit.Instance(Size.little);

		for (int i=0; i<2; i++)
		{
			try
			{
				foo.scoopUp(new FieldMouse()).bopOn(FieldMouse.head);
			}
			catch (GoodFairy.WarningException e)
			{
				assertThat(e.getMessage()).contains("I don't want to see you");
			}
			catch (GoodFairy.ConsequenceException e)
			{
				fail("should not have consequence on first or second try");
			}
		}
	}

	@Test(expected = GoodFairy.ConsequenceException.class)
	public void shouldBePunishedOnThirdTry() throws GoodFairyException
	{
		Foo foo = Rabbit.Instance(Size.little);

		int count = 0;
		while (count < 3)
		{
			try
			{
				// Foo foo should get three chances before being punished
				foo.scoopUp(new FieldMouse()).bopOn(FieldMouse.head);
			}
			catch (GoodFairyException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();

				assertThat(e).isInstanceOf(GoodFairy.WarningException.class);
				assertThat(e.getMessage()).contains("I don't want to see you");
			}
			count++;
		}

		// this time Foo foo should be punished
		foo.scoopUp(new FieldMouse()).bopOn(FieldMouse.head);
	}
}
