package hex.music.api.resource;

import hex.music.api.dto.out.ClefTypeListItemDTO;
import hex.music.api.dto.out.KeySignatureListItemDTO;
import hex.music.api.dto.out.ListItemDTO;
import hex.music.core.domain.Clef;
import hex.music.core.domain.Key;
import hex.music.service.command.tune.GetAvailableClefsCommand;
import hex.music.service.command.tune.GetAvailableKeysCommand;
import hex.music.service.command.tune.GetExistingComposersCommand;
import hex.music.service.command.tune.GetExistingSourcesCommand;
import hex.music.service.command.tune.GetExistingRegionsCommand;
import hex.music.service.command.tune.GetExistingRythmsCommand;
import hex.music.service.command.tune.GetExistingTranscribersCommand;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hln
 */
@Path("list")
public class AutoCompleteResource extends AbstractResource {

    @GET
    @Path("keys")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKeyList() {
        List<Key.Signature> signatures = commandExecutor.execute(new GetAvailableKeysCommand(), getKey());
        List<KeySignatureListItemDTO> result = new ArrayList<>();
        signatures.stream().forEach((s) -> {
            result.add(new KeySignatureListItemDTO(s));
        });
        return Response.ok(result).build();
    }

    @GET
    @Path("clefs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClefList() {
        List<Clef.Type> clefs = commandExecutor.execute(new GetAvailableClefsCommand(), getKey());
        List<ClefTypeListItemDTO> result = new ArrayList<>();
        clefs.stream().forEach((c) -> {
            result.add(new ClefTypeListItemDTO(c));
        });
        return Response.ok(result).build();
    }

    @GET
    @Path("composers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComposerList() {
        List<String> resultList = commandExecutor.execute(new GetExistingComposersCommand(), getKey());
        return createAndReturnResponse(resultList);
    }

    @GET
    @Path("source")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSourceList() {
        List<String> resultList = commandExecutor.execute(new GetExistingSourcesCommand(), getKey());
        return createAndReturnResponse(resultList);
    }

    @GET
    @Path("regions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRegionList() {
        List<String> resultList = commandExecutor.execute(new GetExistingRegionsCommand(), getKey());
        return createAndReturnResponse(resultList);
    }

    @GET
    @Path("rythms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRythmList() {
        List<String> resultList = commandExecutor.execute(new GetExistingRythmsCommand(), getKey());
        return createAndReturnResponse(resultList);
    }

    @GET
    @Path("transcribers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTranscriberList() {
        List<String> resultList = commandExecutor.execute(new GetExistingTranscribersCommand(), getKey());
        return createAndReturnResponse(resultList);
    }

    private Response createAndReturnResponse(List<String> resultList) {
        List<ListItemDTO> result = new ArrayList<>();
        resultList.stream().forEach((item) -> {
            result.add(new ListItemDTO(item));
        });
        return Response.ok(result).build();
    }
}
