package example.micronaut;

import io.micronaut.context.annotation.Requirements;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.core.convert.ArgumentConversionContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.bind.binders.AnnotatedRequestArgumentBinder;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
@Requirements(@Requires(notEnv = Environment.CLI))
public class RequestPathArgumentBinder implements AnnotatedRequestArgumentBinder<RequestPath, String>
{

  @Override
  public BindingResult<String> bind(ArgumentConversionContext<String> context, HttpRequest<?> source)
  {
    return () -> Optional.of(source.getPath());
  }

  @Override
  public Class<RequestPath> getAnnotationType()
  {
    return RequestPath.class;
  }

}
