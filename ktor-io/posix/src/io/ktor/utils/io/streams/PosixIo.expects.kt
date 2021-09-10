/*
 * Copyright 2014-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.utils.io.streams

// Fixme KT-48574

import kotlinx.cinterop.*
import platform.posix.*

public typealias _size_t = size_t // TODO: why?
public typealias _ssize_t = ssize_t // TODO: why?

public expect val SSIZE_MAX: _ssize_t

// TODO: public expect class KX_SOCKET : Number
public typealias KX_SOCKET = Int

public expect class KX_SOCKADDR_LEN : Number

// ACTUAL_WITHOUT_EXPECT

@Suppress("NO_ACTUAL_FOR_EXPECT")
public expect class KX_SOCKADDR_LENVar : CPointed

public expect fun kx_internal_is_non_blocking(socket: KX_SOCKET): Int

public expect fun recv(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __n: _size_t,
    __flags: Int
): _ssize_t

public expect fun send(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __n: _size_t,
    __flags: Int
): _ssize_t

public expect fun recvfrom(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __n: _size_t,
    __flags: Int,
    __addr: CValuesRef<sockaddr>?,
    __addr_len: CValuesRef<KX_SOCKADDR_LENVar>?
): _ssize_t

public expect fun sendto(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __n: _size_t,
    __flags: Int,
    __addr: CValuesRef<sockaddr>?,
    __addr_len: KX_SOCKADDR_LEN
): _ssize_t

public expect fun read(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __nbytes: _size_t
): _ssize_t

public expect fun write(
    __fd: KX_SOCKET,
    __buf: CValuesRef<*>?,
    __n: _size_t
): _ssize_t

public expect fun fwrite(
    __ptr: CValuesRef<*>?,
    __size: _size_t,
    __nitems: _size_t,
    __stream: CValuesRef<FILE>?
): _size_t

public expect fun fread(
    __ptr: CValuesRef<*>?,
    __size: _size_t,
    __nitems: _size_t,
    __stream: CValuesRef<FILE>?
): _size_t
