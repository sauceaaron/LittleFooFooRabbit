public class Rabbit extends Animal
{
	public Rabbit()
	{

	}

	public static Foo Instance(Size size)
	{
		return new Foo(size);
	}

	public Size size;

	public Rabbit(Size size)
	{
		this.size = size;
	}


}
