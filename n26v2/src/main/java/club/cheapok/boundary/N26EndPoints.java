package club.cheapok.boundary;

import club.cheapok.entity.TransactionItem;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("transactions")
public class N26EndPoints {

    @GET
    @Path("hw")
    public String getMethod() {
        return "hello world!";
    }

    @GET
    public TransactionItem getTransactionItem() {
        return new TransactionItem(22.4, System.currentTimeMillis());
    }

    @POST
    public Response postTransactionItem(TransactionItem transactionItem) {

        return Response.accepted().build();
    }
}
