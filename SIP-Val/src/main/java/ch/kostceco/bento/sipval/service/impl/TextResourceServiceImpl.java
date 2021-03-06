/*== SIP-Val ==================================================================================
The SIP-Val application is used for validate Submission Information Package (SIP).
Copyright (C) 2011-2013 Claire R�thlisberger (KOST-CECO), Daniel Ludin (BEDAG AG)
-----------------------------------------------------------------------------------------------
SIP-Val is a development of the KOST-CECO. All rights rest with the KOST-CECO. 
This application is free software: you can redistribute it and/or modify it under the 
terms of the GNU General Public License as published by the Free Software Foundation, 
either version 3 of the License, or (at your option) any later version. 
BEDAG AG and Daniel Ludin hereby disclaims all copyright interest in the program 
SIP-Val v0.2.0 written by Daniel Ludin (BEDAG AG). Switzerland, 1 March 2011.
This application is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
See the follow GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with this program; 
if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, 
Boston, MA 02110-1301 USA or see <http://www.gnu.org/licenses/>.
==============================================================================================*/

package ch.kostceco.bento.sipval.service.impl;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import ch.kostceco.bento.sipval.service.TextResourceService;

/**
 * Dieser Service managt die Zugriffe auf die Resource Bundles.
 * 
 * @author razm Daniel Ludin, Bedag AG @version 0.2.0
 */
public class TextResourceServiceImpl implements TextResourceService
{
	// Per Default ist es dieser Name, kann jedoch auch mittels Dependency
	// Injection �berschrieben werden.
	private String	bundleBaseName	= "messages";

	/**
	 * Gibt den Wert des Attributs <code>bundleBaseName</code> zur�ck.
	 * 
	 * @return Wert des Attributs bundleBaseName.
	 */
	public String getBundleBaseName()
	{
		return bundleBaseName;
	}

	/**
	 * Setzt den Wert des Attributs <code>bundleBaseName</code>.
	 * 
	 * @param bundleBaseName
	 *            Wert f�r das Attribut bundleBaseName.
	 */
	public void setBundleBaseName( String bundleBaseName )
	{
		this.bundleBaseName = bundleBaseName;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText( String aKey, Object... values )
	{

		// For the time being, we use the VM Default Locale
		Locale locale = Locale.getDefault();

		return this.getText( locale, aKey, values );
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText( Locale locale, String aKey, Object... values )
	{

		String theValue = ResourceBundle
				.getBundle( this.bundleBaseName, locale ).getString( aKey );
		return MessageFormat.format( theValue, values );
	}

}
