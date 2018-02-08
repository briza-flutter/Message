/*
 * Copyright (C) 2017 Moez Bhatti <moez.bhatti@gmail.com>
 *
 * This file is part of QKSMS.
 *
 * QKSMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * QKSMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with QKSMS.  If not, see <http://www.gnu.org/licenses/>.
 */
package interactor

import android.net.Uri
import common.util.SyncManager
import data.model.Message
import data.repository.MessageRepository
import io.reactivex.Flowable
import javax.inject.Inject

class SyncMessage @Inject constructor(
        private val syncManager: SyncManager,
        private val messageRepo: MessageRepository
) : Interactor<Uri, Message>() {

    override fun buildObservable(params: Uri): Flowable<Message> {
        return Flowable.just(params)
                .flatMap { uri -> syncManager.syncMessage(uri) }
    }

}