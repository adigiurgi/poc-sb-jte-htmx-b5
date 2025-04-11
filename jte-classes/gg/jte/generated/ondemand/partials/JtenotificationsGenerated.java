package gg.jte.generated.ondemand.partials;
@SuppressWarnings("unchecked")
public final class JtenotificationsGenerated {
	public static final String JTE_NAME = "partials/notifications.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,0,0,2,2,71,71,71,0,0,0,0};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JtenotificationsGenerated.class, "JtenotificationsGenerated.bin", 2,3536);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String contextPath) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String contextPath = (String)params.get("contextPath");
		render(jteOutput, jteHtmlInterceptor, contextPath);
	}
}
