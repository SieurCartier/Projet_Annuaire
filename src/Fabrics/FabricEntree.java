package Fabrics;

public class FabricEntree {

	private static FabricEntree singleton;
	
	private FabricEntree() {

		
		
	}

	public static FabricEntree getInstanceOf() {
		if (singleton == null) {
			singleton = new FabricEntree();
		}
		return singleton ;
	}
}
