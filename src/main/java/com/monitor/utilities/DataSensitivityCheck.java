package com.monitor.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSensitivityCheck {
    private static final Logger logger = LoggerFactory.getLogger(DataSensitivityCheck.class);

	public static void MaskData(String ModifiedData) {
        String[] words = ModifiedData.split("\\s+"); // Split data into words

        for (int i = 0; i < words.length; i++) {
            if (isEmailAddress(words[i])) {
                // If the word is detected as an email address, mask it
                words[i] = maskEmailAddress(words[i]);
            }
        }

        // Reconstruct the data with masked email addresses
        String modifiedData = String.join(" ", words);

        // Send the modified data to the logs
        WriteLog(modifiedData);
    }
    // Log the modified data
	public static void WriteLog(String maskedData) {
        logger.info(maskedData);

	}
    // Check if a word is an email address
    private static boolean isEmailAddress(String word) {
        return word.matches(".*@.*\\..*");
    }

    // Mask an email address
    private static String maskEmailAddress(String email) {
        return "****@****.****"; // Replace with your masking logic
    }


}
