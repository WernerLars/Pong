public class Controller implements IController {


    View view;

    public Controller(){
    }

    public void link(View view){
        this.view=view;
        view.addController(this);
    }

    public void draw(){



    }
    public void remove(){





    }




}
