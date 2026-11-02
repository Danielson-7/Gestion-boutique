
import Service.ClientService;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author danielson
 */
public class Boutique {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		ClientService service = ClientService.getInstance();
		service.trouver(1);

	}
}
