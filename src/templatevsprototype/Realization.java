package templatevsprototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *  Makes deep copy of an instance through the Serializable interface. 
 * 
 * @author Yergalem
 *
 */
interface Prototype {

	public Realization doClone();
}

public class Realization implements Prototype, Cloneable, Serializable {

	String name;
	A a;
	Realization r;

	public Realization() {

	}

	public Realization( A a , String name) {
       this.a  = a;
       this.name = name;
	}

	@Override
	public Realization doClone() {
		Realization obj = null;

		try {

			obj = (Realization) super.clone();

		} catch (CloneNotSupportedException ex) {

			System.out.println("Cloning failure");
			return null;
		}

		return obj;
	}

	public Realization doDeepClone() {
		Realization obj = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream obos = new ObjectOutputStream(baos);

			obos.writeObject(this);

			ByteArrayInputStream bios = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bios);

			obj = (Realization) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public Realization getR() {
		return r;
	}

	public void setR(Realization r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "Realization [name=" + name + ", a=" + a + "]\n" +
	           "r="+r;
	}

	public static void main(String[] args) {

		Realization rl = new Realization();

		System.out.println(" Before");
		rl.setName("Real");
		rl.setA(new A(100));
		rl.getA().setB(new B("Real AB"));
		rl.setR(new Realization(new A(200), "Self Real"));

		System.out.println(rl);
		Realization rlShallow = rl.doClone();
		Realization rlDp = rl.doDeepClone();
		rl.setName("Yergalem");
		rl.getA().setB(new B("Changed"));
		rl.getA().setX(20);
		rl.setR(new Realization(new A(250), "Self Real22"));
		
		System.out.println(" After Shallow");

		System.out.println(rlShallow);

		System.out.println(" After Deep");

		System.out.println(rlDp);
		System.out.println(rl);

	}

}

class A implements Serializable {

	int x;
	B b;

	public A(int val) {
		x = val;
	}

	public int getX() {
		return x;
	}

	public B getB() {
		return b;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setB(B b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "A [x=" + x + ", b=" + b + "]";
	}

}

class B implements Serializable {

	String s;

	public B(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}

}
