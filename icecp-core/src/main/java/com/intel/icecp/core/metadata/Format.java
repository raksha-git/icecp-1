/*
 * ******************************************************************************
 *
 * INTEL CONFIDENTIAL
 *
 * Copyright 2013 - 2016 Intel Corporation All Rights Reserved.
 *
 * The source code contained or described herein and all documents related to
 * the source code ("Material") are owned by Intel Corporation or its suppliers
 * or licensors. Title to the Material remains with Intel Corporation or its
 * suppliers and licensors. The Material contains trade secrets and proprietary
 * and confidential information of Intel or its suppliers and licensors. The
 * Material is protected by worldwide copyright and trade secret laws and treaty
 * provisions. No part of the Material may be used, copied, reproduced,
 * modified, published, uploaded, posted, transmitted, distributed, or disclosed
 * in any way without Intel's prior express written permission.
 *
 * No license under any patent, copyright, trade secret or other intellectual
 * property right is granted to or conferred upon you by disclosure or delivery
 * of the Materials, either expressly, by implication, inducement, estoppel or
 * otherwise. Any license under such intellectual property rights must be
 * express and approved by Intel in writing.
 *
 * Unless otherwise agreed by Intel in writing, you may not remove or alter this
 * notice or any other notice embedded in Materials by Intel or Intel's
 * suppliers or licensors in any way.
 *
 * ******************************************************************************
 */
package com.intel.icecp.core.metadata;

import com.intel.icecp.core.Message;
import com.intel.icecp.core.Metadata;
import com.intel.icecp.core.metadata.formats.FormatEncodingException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Define the format and functionality for encoding messages.
 *
 * @param <T> the type of the message to encode
 */
public interface Format<T extends Message> extends Metadata {

    /**
     * Encode the message for transfer.
     *
     * @param message the {@link Message} to encode
     * @return an {@link InputStream} of message bytes
     * @throws FormatEncodingException if encoding fails
     */
    InputStream encode(T message) throws FormatEncodingException;

    /**
     * Decode the message after transfer.
     *
     * @param stream an {@link InputStream} of message bytes
     * @return the decoded {@link Message}
     * @throws FormatEncodingException if decoding fails
     * @throws IOException if the passed stream cannot be read
     */
    T decode(InputStream stream) throws FormatEncodingException, IOException;
}