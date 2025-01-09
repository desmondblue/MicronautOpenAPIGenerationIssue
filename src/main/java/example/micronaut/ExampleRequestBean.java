package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Introspected
@Nullable
@Getter
@AllArgsConstructor
public class ExampleRequestBean {

    @RequestPath
    @io.swagger.v3.oas.annotations.Parameter(hidden = true)
    private final String path;

    @MethodName
    @io.swagger.v3.oas.annotations.Parameter(hidden = true)
    private final String method;

    @PathVariable
    private String beverageId;

    @PathVariable
    private String teaId;

    @Nullable
    @QueryValue(defaultValue = "0")
    private Integer maxResultCount;

    @Nullable
    @QueryValue(defaultValue = "1")
    private String resultMode;

    @Nullable
    @QueryValue
    private final String reqId;

    @Nullable
    @Parameter(in = ParameterIn.QUERY, description = "defines a map of input fields", required = false)
    private final Map<String, String> params;

    @Setter
    private String            payload = null;

}
