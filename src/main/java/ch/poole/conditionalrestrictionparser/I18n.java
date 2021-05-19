package ch.poole.conditionalrestrictionparser;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.jetbrains.annotations.NotNull;

/**
 * Translation support for {@link ConditionalRestrictionParser}
 * @author JOSM team, Simon Legner
 */
public class I18n {

    private static ResourceBundle messages;

    static {
        setLocale(Locale.ROOT);
    }
    
    /**
     * Private constructor to inhibit instantiation
     */
    private I18n() {
        // empty
    }

    /**
     * Sets the locale used for translations.
     * @param locale the locale
     * @see ResourceBundle#getBundle(java.lang.String, java.util.Locale)
     */
    public static synchronized void setLocale(@NotNull Locale locale) {
        messages = ResourceBundle.getBundle("ch.poole.conditionalrestrictionparser.Messages", locale);
    }

    /**
     * Returns the translation for the given translation {@code key} and the supplied {@code arguments}.
     * @param key the translation key to {@linkplain ResourceBundle#getString fetch} the translation
     * @param arguments the translation arguments which are used {@linkplain MessageFormat#format for formatting}
     * @return the translated string
     */
    public static String tr(@NotNull String key, Object... arguments) {
        return MessageFormat.format(messages.getString(key), arguments);
    }
}
