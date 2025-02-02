package io.p13i.ra.databases.localdisk;

import io.p13i.ra.databases.cache.ICachableDocument;
import io.p13i.ra.models.AbstractDocument;
import io.p13i.ra.models.Context;
import io.p13i.ra.utils.DateUtils;
import io.p13i.ra.utils.FileIO;
import io.p13i.ra.utils.StringUtils;

import java.io.File;
import java.util.Date;

/**
 * Represents one document on the local disk
 */
public class LocalDiskDocument extends AbstractDocument implements ICachableDocument {
    private final Date lastModified;
    private final String filename;

    public LocalDiskDocument(String content, String filename, String subject, Date lastModified, String url) {
        super(content, new Context(null, null, subject, lastModified));
        this.filename = filename;
        this.lastModified = lastModified;
        this.url = url;
    }

    @Override
    public String toString() {
        return "<" + getDocumentTypeName() + " content='" + getContentTruncated() + "' filename='" + filename + " last modified=" + DateUtils.timestampOf(this.lastModified) + "'>";
    }
}
