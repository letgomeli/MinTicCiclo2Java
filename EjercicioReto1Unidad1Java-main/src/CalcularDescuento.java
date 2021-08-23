public class CalcularDescuento{
	//Atributos
	private int monto;
	private int descuento;
	private double total;

	//Constructor

	public CalcularDescuento(){
	    this.monto = 0;
	    this.descuento = 0;
	    this.total = 0.0;
	}
        
	public CalcularDescuento(int monto){
	    this.monto = monto;
	    this.descuento = 0;
	    this.total = 0.0;
	}
	
        public int descuento(int monto){
	    if(monto > 100000){
                this.descuento = (monto * 10)/100;
	    }else{
		this.descuento = (monto * 2)/100;
	    }
            return this.descuento; //descuento da igual
	}

	public int descuento(){
	    if(this.monto > 100000){
                this.descuento = (this.monto * 10)/100;
	    }else{
		this.descuento = (this.monto * 2)/100;   
	    }
            return this.descuento; //descuento da igual
	}

        public Double total(){
	    descuento();
            this.total = this.monto - this.descuento;
	    return this.total; //o total
	}

        public Double total(int monto){
	    descuento(monto);
	    this.total = monto - this.descuento;
	    return this.total;
	}
	  
        public static void main(String[] args){
	    CalcularDescuento descuento1 = new CalcularDescuento(5000000);
	    System.out.println(descuento1.total());

	    CalcularDescuento descuento2 = new CalcularDescuento();
	    System.out.println(descuento2.total(90000));
	}
}

