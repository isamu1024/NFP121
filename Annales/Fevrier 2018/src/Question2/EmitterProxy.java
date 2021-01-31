package Question2;

import Question1.*;

public class EmitterProxy extends Emitter implements EmitterI {

    AuthorizedUsers auth;

    public EmitterProxy(String name){
        super(name);
        auth = AuthorizedUsers.getInstance();
    }

    @Override
    public int sendMessage(String msg) {
        if (this.auth.users().contains(this.getName())){
            return super.sendMessage(msg);
        }

        return 0;
    }


}
