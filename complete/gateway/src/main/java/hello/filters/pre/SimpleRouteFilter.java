package hello.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SimpleRouteFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleRouteFilter.class);

  @Override
  public String filterType() {
    return "route";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
    List<String> country = requestQueryParams.get("country");
    try
    {
      if("india".equals(country.get(0)))
      {
        log.info("India");
        ctx.setRouteHost(new URL("http://www.google.com"));
      }
      else if("pak".equals(country.get(0)))
      {
        log.info("pak");
        ctx.setRouteHost(new URL("http://www.dawn.com"));
      }
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    if("india".equals(country.get(0)))
      log.info("India");
    else if("pak".equals(country.get(0)))
      log.info("pak");
    return null;
  }

}
