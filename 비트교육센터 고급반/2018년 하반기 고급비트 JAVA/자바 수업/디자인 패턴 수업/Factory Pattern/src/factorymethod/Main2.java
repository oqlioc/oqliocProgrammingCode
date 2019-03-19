package factorymethod;

interface Button
{
	public void Click();
}//interface Button

interface TextArea
{
	public String getText();
}//interface TextArea

interface GuiFac
{
	public Button createButton();
	public TextArea createTextArea();
}// GuiFac

class WinButton implements Button
{
	@Override
	public void Click()
	{
		System.out.println("윈도우 버튼이 클릭됨");
	}
}//WinButton
class WinTextArea implements TextArea
{

	@Override
	public String getText()
	{
		return "Window Text Area";
	}
}//WinTextarea
class WinFac implements GuiFac
{
	@Override
	public Button createButton()
	{
		return new WinButton();
	}

	@Override
	public TextArea createTextArea()
	{
		return new WinTextArea();
	}
}//WinFac

class LinuxButton implements Button
{
	@Override
	public void Click()
	{
		System.out.println("윈도우 버튼이 클릭됨");
	}
}//LinuxButton
class LinuxTextArea implements TextArea
{

	@Override
	public String getText()
	{
		return "Linux Text Area";
	}
}//LinuxTextarea
class LinuxFac implements GuiFac
{
	@Override
	public Button createButton()
	{
		return new LinuxButton();
	}

	@Override
	public TextArea createTextArea()
	{
		return new LinuxTextArea();
	}
}//LinuxFac

class MacButton implements Button
{
	@Override
	public void Click()
	{
		System.out.println("윈도우 버튼이 클릭됨");
	}
}//MacButton
class MacTextArea implements TextArea
{

	@Override
	public String getText()
	{
		return "Mac Text Area";
	}
}//MacTextarea
class MacFac implements GuiFac
{
	@Override
	public Button createButton()
	{
		return new MacButton();
	}

	@Override
	public TextArea createTextArea()
	{
		return new MacTextArea();
	}
}//MacFac

class GutGetter
{
	public static GuiFac getGuiFac()
	{
		switch(System.getProperty("os.name"))
		{
		case "Windows 10":
			return new WinFac();
		case "Mac OS X":
			return new MacFac();
		}
		return null;
	}
}//GutGetter

public class Main2
{

	public static void main(String[] args)
	{
		GuiFac fac = GutGetter.getGuiFac();
		Button b = fac.createButton();
		TextArea t = fac.createTextArea();
		b.Click();
		System.out.println(t.getText());
		
	}

}//Main2
