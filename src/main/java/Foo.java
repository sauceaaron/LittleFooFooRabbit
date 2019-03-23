public class Foo extends Rabbit
{
	public int scoopCount = 0;
	public int bopCount = 0;

	public Foo(Size size)
	{
		super(size);
	}

	public Foo scoopUp(Animal animal)
	{
		scoopCount++;
		return this;
	}

	public void bopOn(BodyPart part) throws GoodFairy.ConsequenceException, GoodFairy.WarningException
	{
		bopCount++;

		if (bopCount <= 3)
		{
			throw new GoodFairy.WarningException();
		}

		throw new GoodFairy.ConsequenceException();
	}

}
