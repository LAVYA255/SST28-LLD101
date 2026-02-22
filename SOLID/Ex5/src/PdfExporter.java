import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String body = req.body == null ? "" : req.body;
        if (body.length() > 20) {
            String msg = "PDF cannot handle content > 20 chars";
            return new ExportResult("application/pdf", msg.getBytes(StandardCharsets.UTF_8));
        }
        String fakePdf = "PDF(" + req.title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}