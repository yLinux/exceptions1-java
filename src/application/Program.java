package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		 * 1 - implementando classe que é a minha reserva
		 * 2 - Criando construtores (usings e fields)
		 * 3 - criando getters and setter
		 * ( apaguei set checkout e set checkin pq eu n vou deixar sejam mudadas arbitrariamente) 
		 * 4 - Implementar classe "duração em dias" -method
		 * 5 - Implementando a operação updates Date' method (vai receber 2 datas notas, e vai atualizar o checkIN e o checkOUT 
		 * 6 - recebendo os checkIn e CheckOut
		 * 7 - Implementar toString na classe reservation ( colocar @Override = pq o toString é uma sobreposiçao) == sempre iremos colocar o @Override no toString
		 * 8 - Implementar a lógica do toString
		 * 9 - formatando a data do "check in" date
		 * 10 - Declarando SimpleDateFOrmat pq vamos mexer com data
		 * 11 - lógica ler nº quarto + data checkin + data checkout
		 * 12 - Instanciar minha reserva
		 * (minha data de reserva, n pode ser posterior a data de check-in) 
		 * 13 - implementar atualização da data
		 * 14 - imprimindo de novo 'reserva'
		 * 15 - Aplicar regras de validação (para o programa nao aceitar datas passadas) (datas para validação nao podem ser anteriores a data atual ) 
		 * 
		 * 
		 */
		
			
		Scanner sc = new Scanner(System.in);
		//10
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//11 
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); //mouse em cima -> add Trhow exception (para parar de dar erro)
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); //mouse em cima -> add Trhow exception (para parar de dar erro)
		
		//12
		if ( !checkOut.after(checkIn) ) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut); //Instanciando reservation
			System.out.println("Reservation: " + reservation); //mostrando os dados da reserva (concatenei com a reserva) 
			//13
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); //Tira declaração do date, pq as var ja foram declaradas em cima
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());//Tira declaração do date, pq as var ja foram declaradas em cima																			
			//15
			Date now = new Date(); //Command = criar uma var com a data de agora 
			if(checkIn.before(now) || checkOut.before(now)) { //se a data de checkIn for anterios (before) ou (||) se a dataa de checkOut for antes (b) (NOw AGORA == nao posso aceitar
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if ( !checkOut.after(checkIn) ) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");		
			}					 
			else {
				reservation.updateDates(checkIn, checkOut); //method responsavel para atualizar sua data 
				//14
				System.out.println("Reservation: " + reservation);		
			}	
			
		}
		
		sc.close();
		
	}

}

