package org.avm.css.less;

import org.apache.log4j.Logger;

public class LessServlet extends com.asual.lesscss.LessServlet {

	private static final long serialVersionUID = -2366855812250152114L;

	private static final Logger LOGGER = Logger.getLogger(LessServlet.class);

	@Override
	protected String getResorceMimeType(String uri) {
		LOGGER.debug("[getResorceMimeType()][uri=" + uri + "]");
		String extension = uri.substring(uri.lastIndexOf(".") + 1);
		LOGGER.debug("[getResorceMimeType()][extension=" + extension + "]");

		String mimeType = mimeTypes.containsKey(extension) ? mimeTypes.get(extension) : getServletContext().getMimeType(uri);
		if ("less".equals(extension)) {
			mimeType = "text/css";
		}

		LOGGER.debug("[getResorceMimeType()][mimeType=" + mimeType + "]");
		return mimeType != null ? mimeType : "application/octet-stream";
	}
}
