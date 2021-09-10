/*
 * Copyright 2014-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.utils.io.streams

import kotlinx.cinterop.*
import platform.posix.*

@Suppress("ACTUAL_WITHOUT_EXPECT")
public actual typealias KX_SOCKADDR_LEN = UInt

@Suppress("ACTUAL_TYPE_ALIAS_NOT_TO_CLASS", "ACTUAL_WITHOUT_EXPECT")
public actual typealias KX_SOCKADDR_LENVar = UIntVar

/**
 *  From sockets.def:
 *   static inline int kx_internal_is_non_blocking(int fd) {
 *       int flags = fcntl(fd, F_GETFL, 0);
 *       return flags & O_NONBLOCK;
 *   }
 */
public actual fun kx_internal_is_non_blocking(socket: KX_SOCKET): Int {
    val flags = fcntl(socket, F_GETFL, 0)
    return flags and O_NONBLOCK
}
