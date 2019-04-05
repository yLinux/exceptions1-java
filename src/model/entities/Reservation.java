package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	//1
	private Integer roomBumber;
	private Date checkIn;
	private Date checkOut;
	//9
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Colocamo 'static1' pq iremos precisar de apenas 1
	//2
	public Reservation(Integer roomBumber, Date checkIn, Date checkOut) {
		this.roomBumber = roomBumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	//3
	public Integer getRoomBumber() {
		return roomBumber;
	}
	public void setRoomBumber(Integer roomBumber) {
		this.roomBumber = roomBumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	//4
	public long duration () {
		long diff = checkOut.getTime() - checkIn.getTime(); //Vai me devolver diferença entre as duas datas em milisegundos
		TimeUnit.DAYS.convert(diff,  TimeUnit.MILLISECONDS);  //Convertendo milisegundos para dias 
		return TimeUnit.DAYS.convert(diff,  TimeUnit.MILLISECONDS); //Fazendo meu método retornar esse valor 
	}
	//5
	public String updateDates (Date checkIn, Date checkOut) { //() = recebendo valores, oq estiver ai dentro
		//16
		Date now = new Date(); //Command = criar uma var com a data de agora 
		if(checkIn.before(now) || checkOut.before(now)) { //se a data de checkIn for anterios (before) ou (||) se a dataa de checkOut for antes (b) (NOw AGORA == nao posso aceitar
			return "Error in reservation: Reservation dates for update must be future dates";
		}																									
		if ( !checkOut.after(checkIn) ) {
			return "Error in reservation: Check-out date must be after check-in date";		
		}																									 
		//6
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//17
		return null; //se retornar nulo é pq nao deu nenhum erro
	}
	//7
	@Override 
	public String toString() {
		//8
		return "Room " //é o que o method terá que retornar
			+ roomBumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration() 
			+ " nights";	
	}
	
}
