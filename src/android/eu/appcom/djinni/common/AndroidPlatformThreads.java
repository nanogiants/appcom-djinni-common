//
// Copyright 2015 Dropbox, Inc.
// Modified work Copyright (c) 2017 appcom interactive GmbH.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package eu.appcom.djinni.common;

import android.os.Looper;

/**
 * Cross-language platform thread implementation for Android Java.
 * Create a subclass and override configureThread() to customize the created threads.
 */
public class AndroidPlatformThreads extends JavaPlatformThreads {
    private static Looper sMainLooper = Looper.getMainLooper();

    /**
     * Creates an instance.
     */
    public AndroidPlatformThreads() {
    }

    /**
     * Determines whether the calling thread is the main UI thread of the
     * app.  Some platforms do not have a notion of a main thread, in which
     * case this method returns null.
     *
     * This implementation returns true or false based on the Android UI's
     * notion of a main thread.
     */
    @Override
    public Boolean isMainThread() {
        return Looper.myLooper() == sMainLooper;
    }
}
