/*******************************************************************************
 * Copyright 2014 Alexander Leontyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.woodblockwithoutco.quickcontroldock.prefs.resolvers;

import android.content.Context;

import com.woodblockwithoutco.quickcontroldock.prefs.Keys;

public class BackupResolver extends BasePrefsResolver {

	public static String getBackupName(Context context) {
		String result = getString(context, Keys.Backup.BACKUP_NAME, "Backup");
		if(result.isEmpty()) return "Backup";
		return result;
	}
	
	public static String getRestoreBackupName(Context context) {
		return getString(context, Keys.Backup.BACKUP_RESTORE_NAME, "-");
	}
}
