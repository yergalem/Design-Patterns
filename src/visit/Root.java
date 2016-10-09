package visit;

public class Root extends Composite{
	private String name;
	
	public Root(String name){
		super();
		this.name = name;
		side = Side.NONE;
	}
	
		
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Side getSide(){
		return side;
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
        
        @Override
        public String toString(){
          return name;  
        }
}
