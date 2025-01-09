/*
 * Copyright 2017-2024 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.micronaut;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.RequestBean;
import io.micronaut.http.uri.UriBuilder;
import io.swagger.v3.oas.annotations.Hidden;
import java.net.URI;
import java.util.Map;

@Controller // <1>
class HomeController {

    private final static URI SWAGGER_UI = UriBuilder.of("/swagger-ui").path("index.html").build();

    @Post(value = "/example/{beverageId}/{teaId}{?reqId,maxResultCount}", processes = "application/json;charset=UTF-8")
    public HttpResponse<?> bulkCheck(@RequestBean ExampleRequestBean bean, @Nullable @Body String content) {
        return HttpResponse.seeOther(SWAGGER_UI);
    }
}
