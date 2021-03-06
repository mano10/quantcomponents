/*******************************************************************************
 * Copyright (c) 2013 Luigi Sgro. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Luigi Sgro - initial API and implementation
 ******************************************************************************/
package com.quantcomponents.ib;

import java.util.TimeZone;

import com.ib.client.ContractDetails;
import com.quantcomponents.core.model.IContractDesc;

public class IBContractDesc implements IContractDesc {
	private final ContractDetails details;
	private final IBConstantTranslator constantTranslator;

	public IBContractDesc(ContractDetails details, IBConstantTranslator constantTranslator) {
		this.details = details;
		this.constantTranslator = constantTranslator;
	}

	@Override
	public String getLongName() {
		return details.m_longName;
	}

	@Override
	public TimeZone getTimeZone() {
		if (details.m_timeZoneId != null) {
			return constantTranslator.getTimeZone(details.m_timeZoneId);
		} else {
			return null;
		}
	}
}
