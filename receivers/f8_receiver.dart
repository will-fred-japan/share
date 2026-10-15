// lib: , url: package:roselink_bluetooth/commander/receiver/f8_receiver.dart

// class id: 1050398, size: 0x8
class :: {
}

// class id: 448, size: 0x10, field offset: 0xc
class F8Receiver extends RReceiver {

  _ checkModule(/* No info */) {
    // ** addr: 0xedb874, size: 0x5c
    // 0xedb874: EnterFrame
    //     0xedb874: stp             fp, lr, [SP, #-0x10]!
    //     0xedb878: mov             fp, SP
    // 0xedb87c: CheckStackOverflow
    //     0xedb87c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xedb880: cmp             SP, x16
    //     0xedb884: b.ls            #0xedb8c8
    // 0xedb888: r0 = LoadStaticField(0x804)
    //     0xedb888: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xedb88c: ldr             x0, [x0, #0x1008]
    // 0xedb890: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xedb894: cmp             w0, w16
    // 0xedb898: b.ne            #0xedb8a4
    // 0xedb89c: r2 = rsbt
    //     0xedb89c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xedb8a0: r0 = InitLateFinalStaticField()
    //     0xedb8a0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xedb8a4: LoadField: r1 = r0->field_1f
    //     0xedb8a4: ldur            w1, [x0, #0x1f]
    // 0xedb8a8: DecompressPointer r1
    //     0xedb8a8: add             x1, x1, HEAP, lsl #32
    // 0xedb8ac: r2 = "[commander] 模块检查 f8协议暂不支持模块消息检查功能"
    //     0xedb8ac: add             x2, PP, #0x13, lsl #12  ; [pp+0x136e8] "[commander] 模块检查 f8协议暂不支持模块消息检查功能"
    //     0xedb8b0: ldr             x2, [x2, #0x6e8]
    // 0xedb8b4: r0 = i()
    //     0xedb8b4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xedb8b8: r0 = false
    //     0xedb8b8: add             x0, NULL, #0x30  ; false
    // 0xedb8bc: LeaveFrame
    //     0xedb8bc: mov             SP, fp
    //     0xedb8c0: ldp             fp, lr, [SP], #0x10
    // 0xedb8c4: ret
    //     0xedb8c4: ret             
    // 0xedb8c8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xedb8c8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xedb8cc: b               #0xedb888
  }
  _ process(/* No info */) {
    // ** addr: 0xefa624, size: 0x468
    // 0xefa624: EnterFrame
    //     0xefa624: stp             fp, lr, [SP, #-0x10]!
    //     0xefa628: mov             fp, SP
    // 0xefa62c: AllocStack(0x30)
    //     0xefa62c: sub             SP, SP, #0x30
    // 0xefa630: r0 = false
    //     0xefa630: add             x0, NULL, #0x30  ; false
    // 0xefa634: mov             x4, x1
    // 0xefa638: mov             x3, x2
    // 0xefa63c: stur            x1, [fp, #-8]
    // 0xefa640: stur            x2, [fp, #-0x10]
    // 0xefa644: CheckStackOverflow
    //     0xefa644: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefa648: cmp             SP, x16
    //     0xefa64c: b.ls            #0xefaa84
    // 0xefa650: StoreField: r4->field_b = r0
    //     0xefa650: stur            w0, [x4, #0xb]
    // 0xefa654: r16 = 8
    //     0xefa654: movz            x16, #0x8
    // 0xefa658: str             x16, [SP]
    // 0xefa65c: mov             x1, x3
    // 0xefa660: r2 = 2
    //     0xefa660: movz            x2, #0x2
    // 0xefa664: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa664: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa668: r0 = substring()
    //     0xefa668: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa66c: mov             x1, x0
    // 0xefa670: stur            x1, [fp, #-0x18]
    // 0xefa674: r0 = LoadClassIdInstr(r1)
    //     0xefa674: ldur            x0, [x1, #-1]
    //     0xefa678: ubfx            x0, x0, #0xc, #0x14
    // 0xefa67c: r16 = "27"
    //     0xefa67c: add             x16, PP, #0x13, lsl #12  ; [pp+0x136f0] "27"
    //     0xefa680: ldr             x16, [x16, #0x6f0]
    // 0xefa684: stp             x16, x1, [SP]
    // 0xefa688: mov             lr, x0
    // 0xefa68c: ldr             lr, [x21, lr, lsl #3]
    // 0xefa690: blr             lr
    // 0xefa694: tbz             w0, #4, #0xefa74c
    // 0xefa698: ldur            x0, [fp, #-0x18]
    // 0xefa69c: r1 = LoadClassIdInstr(r0)
    //     0xefa69c: ldur            x1, [x0, #-1]
    //     0xefa6a0: ubfx            x1, x1, #0xc, #0x14
    // 0xefa6a4: r16 = "28"
    //     0xefa6a4: add             x16, PP, #0x13, lsl #12  ; [pp+0x136f8] "28"
    //     0xefa6a8: ldr             x16, [x16, #0x6f8]
    // 0xefa6ac: stp             x16, x0, [SP]
    // 0xefa6b0: mov             x0, x1
    // 0xefa6b4: mov             lr, x0
    // 0xefa6b8: ldr             lr, [x21, lr, lsl #3]
    // 0xefa6bc: blr             lr
    // 0xefa6c0: tbz             w0, #4, #0xefa744
    // 0xefa6c4: ldur            x1, [fp, #-0x10]
    // 0xefa6c8: r0 = LoadStaticField(0x804)
    //     0xefa6c8: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefa6cc: ldr             x0, [x0, #0x1008]
    // 0xefa6d0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefa6d4: cmp             w0, w16
    // 0xefa6d8: b.ne            #0xefa6e4
    // 0xefa6dc: r2 = rsbt
    //     0xefa6dc: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefa6e0: r0 = InitLateFinalStaticField()
    //     0xefa6e0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefa6e4: LoadField: r3 = r0->field_1f
    //     0xefa6e4: ldur            w3, [x0, #0x1f]
    // 0xefa6e8: DecompressPointer r3
    //     0xefa6e8: add             x3, x3, HEAP, lsl #32
    // 0xefa6ec: stur            x3, [fp, #-0x18]
    // 0xefa6f0: r1 = Null
    //     0xefa6f0: mov             x1, NULL
    // 0xefa6f4: r2 = 6
    //     0xefa6f4: movz            x2, #0x6
    // 0xefa6f8: r0 = AllocateArray()
    //     0xefa6f8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefa6fc: r16 = "[receiver] 不归我处理，咋跑到我这里了？【"
    //     0xefa6fc: add             x16, PP, #0x13, lsl #12  ; [pp+0x13700] "[receiver] 不归我处理，咋跑到我这里了？【"
    //     0xefa700: ldr             x16, [x16, #0x700]
    // 0xefa704: StoreField: r0->field_f = r16
    //     0xefa704: stur            w16, [x0, #0xf]
    // 0xefa708: ldur            x3, [fp, #-0x10]
    // 0xefa70c: StoreField: r0->field_13 = r3
    //     0xefa70c: stur            w3, [x0, #0x13]
    // 0xefa710: r16 = "】"
    //     0xefa710: add             x16, PP, #0x13, lsl #12  ; [pp+0x13708] "】"
    //     0xefa714: ldr             x16, [x16, #0x708]
    // 0xefa718: ArrayStore: r0[0] = r16  ; List_4
    //     0xefa718: stur            w16, [x0, #0x17]
    // 0xefa71c: str             x0, [SP]
    // 0xefa720: r0 = _interpolate()
    //     0xefa720: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefa724: ldur            x1, [fp, #-0x18]
    // 0xefa728: mov             x2, x0
    // 0xefa72c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefa72c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefa730: r0 = w()
    //     0xefa730: bl              #0x6bf3f0  ; [package:logger/src/logger.dart] Logger::w
    // 0xefa734: r0 = Null
    //     0xefa734: mov             x0, NULL
    // 0xefa738: LeaveFrame
    //     0xefa738: mov             SP, fp
    //     0xefa73c: ldp             fp, lr, [SP], #0x10
    // 0xefa740: ret
    //     0xefa740: ret             
    // 0xefa744: ldur            x3, [fp, #-0x10]
    // 0xefa748: b               #0xefa750
    // 0xefa74c: ldur            x3, [fp, #-0x10]
    // 0xefa750: r16 = 24
    //     0xefa750: movz            x16, #0x18
    // 0xefa754: str             x16, [SP]
    // 0xefa758: mov             x1, x3
    // 0xefa75c: r2 = 10
    //     0xefa75c: movz            x2, #0xa
    // 0xefa760: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa760: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa764: r0 = substring()
    //     0xefa764: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa768: r1 = LoadClassIdInstr(r0)
    //     0xefa768: ldur            x1, [x0, #-1]
    //     0xefa76c: ubfx            x1, x1, #0xc, #0x14
    // 0xefa770: str             x0, [SP]
    // 0xefa774: mov             x0, x1
    // 0xefa778: r0 = GDT[cid_x0 + -0x1000]()
    //     0xefa778: sub             lr, x0, #1, lsl #12
    //     0xefa77c: ldr             lr, [x21, lr, lsl #3]
    //     0xefa780: blr             lr
    // 0xefa784: stur            x0, [fp, #-0x18]
    // 0xefa788: r16 = 32
    //     0xefa788: movz            x16, #0x20
    // 0xefa78c: str             x16, [SP]
    // 0xefa790: ldur            x1, [fp, #-0x10]
    // 0xefa794: r2 = 14
    //     0xefa794: movz            x2, #0xe
    // 0xefa798: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa798: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa79c: r0 = substring()
    //     0xefa79c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa7a0: stur            x0, [fp, #-0x20]
    // 0xefa7a4: r16 = "01"
    //     0xefa7a4: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc98] "01"
    //     0xefa7a8: ldr             x16, [x16, #0xc98]
    // 0xefa7ac: ldur            lr, [fp, #-0x18]
    // 0xefa7b0: stp             lr, x16, [SP]
    // 0xefa7b4: r0 = ==()
    //     0xefa7b4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa7b8: tbnz            w0, #4, #0xefa7cc
    // 0xefa7bc: ldur            x1, [fp, #-8]
    // 0xefa7c0: ldur            x2, [fp, #-0x10]
    // 0xefa7c4: r0 = _handleBatteryData()
    //     0xefa7c4: bl              #0xefb9f4  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleBatteryData
    // 0xefa7c8: b               #0xefaa58
    // 0xefa7cc: r16 = "02"
    //     0xefa7cc: add             x16, PP, #0xb, lsl #12  ; [pp+0xbca8] "02"
    //     0xefa7d0: ldr             x16, [x16, #0xca8]
    // 0xefa7d4: ldur            lr, [fp, #-0x18]
    // 0xefa7d8: stp             lr, x16, [SP]
    // 0xefa7dc: r0 = ==()
    //     0xefa7dc: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa7e0: tbnz            w0, #4, #0xefa80c
    // 0xefa7e4: r16 = 44
    //     0xefa7e4: movz            x16, #0x2c
    // 0xefa7e8: str             x16, [SP]
    // 0xefa7ec: ldur            x1, [fp, #-0x10]
    // 0xefa7f0: r2 = 18
    //     0xefa7f0: movz            x2, #0x12
    // 0xefa7f4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa7f4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa7f8: r0 = substring()
    //     0xefa7f8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa7fc: ldur            x1, [fp, #-8]
    // 0xefa800: mov             x2, x0
    // 0xefa804: r0 = _handleFirmwareVersion()
    //     0xefa804: bl              #0xefb8c4  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleFirmwareVersion
    // 0xefa808: b               #0xefaa58
    // 0xefa80c: r16 = "04"
    //     0xefa80c: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc60] "04"
    //     0xefa810: ldr             x16, [x16, #0xc60]
    // 0xefa814: ldur            lr, [fp, #-0x18]
    // 0xefa818: stp             lr, x16, [SP]
    // 0xefa81c: r0 = ==()
    //     0xefa81c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa820: tbnz            w0, #4, #0xefa8ac
    // 0xefa824: r16 = 24
    //     0xefa824: movz            x16, #0x18
    // 0xefa828: str             x16, [SP]
    // 0xefa82c: ldur            x1, [fp, #-0x10]
    // 0xefa830: r2 = 8
    //     0xefa830: movz            x2, #0x8
    // 0xefa834: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa834: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa838: r0 = substring()
    //     0xefa838: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa83c: r1 = LoadClassIdInstr(r0)
    //     0xefa83c: ldur            x1, [x0, #-1]
    //     0xefa840: ubfx            x1, x1, #0xc, #0x14
    // 0xefa844: r16 = "0404"
    //     0xefa844: add             x16, PP, #0x13, lsl #12  ; [pp+0x13710] "0404"
    //     0xefa848: ldr             x16, [x16, #0x710]
    // 0xefa84c: stp             x16, x0, [SP]
    // 0xefa850: mov             x0, x1
    // 0xefa854: mov             lr, x0
    // 0xefa858: ldr             lr, [x21, lr, lsl #3]
    // 0xefa85c: blr             lr
    // 0xefa860: tbnz            w0, #4, #0xefa884
    // 0xefa864: ldur            x1, [fp, #-0x10]
    // 0xefa868: r2 = 17
    //     0xefa868: movz            x2, #0x11
    // 0xefa86c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefa86c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefa870: r0 = substring()
    //     0xefa870: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa874: ldur            x1, [fp, #-8]
    // 0xefa878: mov             x2, x0
    // 0xefa87c: r0 = _handleEQData()
    //     0xefa87c: bl              #0xefb7cc  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleEQData
    // 0xefa880: b               #0xefaa58
    // 0xefa884: r16 = 36
    //     0xefa884: movz            x16, #0x24
    // 0xefa888: str             x16, [SP]
    // 0xefa88c: ldur            x1, [fp, #-0x10]
    // 0xefa890: r2 = 16
    //     0xefa890: movz            x2, #0x10
    // 0xefa894: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefa894: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefa898: r0 = substring()
    //     0xefa898: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa89c: ldur            x1, [fp, #-8]
    // 0xefa8a0: mov             x2, x0
    // 0xefa8a4: r0 = _handleEQData()
    //     0xefa8a4: bl              #0xefb7cc  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleEQData
    // 0xefa8a8: b               #0xefaa58
    // 0xefa8ac: r16 = "05"
    //     0xefa8ac: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc70] "05"
    //     0xefa8b0: ldr             x16, [x16, #0xc70]
    // 0xefa8b4: ldur            lr, [fp, #-0x18]
    // 0xefa8b8: stp             lr, x16, [SP]
    // 0xefa8bc: r0 = ==()
    //     0xefa8bc: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa8c0: tbnz            w0, #4, #0xefa8d4
    // 0xefa8c4: ldur            x1, [fp, #-8]
    // 0xefa8c8: ldur            x2, [fp, #-0x10]
    // 0xefa8cc: r0 = _handleKeyData()
    //     0xefa8cc: bl              #0xefb378  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleKeyData
    // 0xefa8d0: b               #0xefaa58
    // 0xefa8d4: r16 = "08"
    //     0xefa8d4: add             x16, PP, #0x12, lsl #12  ; [pp+0x128c8] "08"
    //     0xefa8d8: ldr             x16, [x16, #0x8c8]
    // 0xefa8dc: ldur            lr, [fp, #-0x18]
    // 0xefa8e0: stp             lr, x16, [SP]
    // 0xefa8e4: r0 = ==()
    //     0xefa8e4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa8e8: tbnz            w0, #4, #0xefa8fc
    // 0xefa8ec: ldur            x1, [fp, #-8]
    // 0xefa8f0: ldur            x2, [fp, #-0x20]
    // 0xefa8f4: r0 = _handleGameMode()
    //     0xefa8f4: bl              #0xefb270  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleGameMode
    // 0xefa8f8: b               #0xefaa58
    // 0xefa8fc: r16 = "09"
    //     0xefa8fc: add             x16, PP, #0x12, lsl #12  ; [pp+0x128b0] "09"
    //     0xefa900: ldr             x16, [x16, #0x8b0]
    // 0xefa904: ldur            lr, [fp, #-0x18]
    // 0xefa908: stp             lr, x16, [SP]
    // 0xefa90c: r0 = ==()
    //     0xefa90c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa910: tbnz            w0, #4, #0xefa934
    // 0xefa914: ldur            x1, [fp, #-0x10]
    // 0xefa918: r2 = 15
    //     0xefa918: movz            x2, #0xf
    // 0xefa91c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefa91c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefa920: r0 = substring()
    //     0xefa920: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa924: ldur            x1, [fp, #-8]
    // 0xefa928: mov             x2, x0
    // 0xefa92c: r0 = _handleInEarDetection()
    //     0xefa92c: bl              #0xefb168  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleInEarDetection
    // 0xefa930: b               #0xefaa58
    // 0xefa934: r16 = "0a"
    //     0xefa934: add             x16, PP, #0x13, lsl #12  ; [pp+0x13718] "0a"
    //     0xefa938: ldr             x16, [x16, #0x718]
    // 0xefa93c: ldur            lr, [fp, #-0x18]
    // 0xefa940: stp             lr, x16, [SP]
    // 0xefa944: r0 = ==()
    //     0xefa944: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa948: tbnz            w0, #4, #0xefa95c
    // 0xefa94c: ldur            x1, [fp, #-8]
    // 0xefa950: ldur            x2, [fp, #-0x20]
    // 0xefa954: r0 = _handleEarLanguage()
    //     0xefa954: bl              #0xefb064  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleEarLanguage
    // 0xefa958: b               #0xefaa58
    // 0xefa95c: r16 = "0b"
    //     0xefa95c: add             x16, PP, #0x13, lsl #12  ; [pp+0x13720] "0b"
    //     0xefa960: ldr             x16, [x16, #0x720]
    // 0xefa964: ldur            lr, [fp, #-0x18]
    // 0xefa968: stp             lr, x16, [SP]
    // 0xefa96c: r0 = ==()
    //     0xefa96c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa970: tbnz            w0, #4, #0xefa994
    // 0xefa974: ldur            x1, [fp, #-0x10]
    // 0xefa978: r2 = 14
    //     0xefa978: movz            x2, #0xe
    // 0xefa97c: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefa97c: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefa980: r0 = substring()
    //     0xefa980: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefa984: ldur            x1, [fp, #-8]
    // 0xefa988: mov             x2, x0
    // 0xefa98c: r0 = _handleConnectionMode()
    //     0xefa98c: bl              #0xefaf70  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleConnectionMode
    // 0xefa990: b               #0xefaa58
    // 0xefa994: r16 = "0c"
    //     0xefa994: add             x16, PP, #0x12, lsl #12  ; [pp+0x128b8] "0c"
    //     0xefa998: ldr             x16, [x16, #0x8b8]
    // 0xefa99c: ldur            lr, [fp, #-0x18]
    // 0xefa9a0: stp             lr, x16, [SP]
    // 0xefa9a4: r0 = ==()
    //     0xefa9a4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa9a8: tbnz            w0, #4, #0xefa9bc
    // 0xefa9ac: ldur            x1, [fp, #-8]
    // 0xefa9b0: ldur            x2, [fp, #-0x20]
    // 0xefa9b4: r0 = _handleANCData()
    //     0xefa9b4: bl              #0xefae78  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleANCData
    // 0xefa9b8: b               #0xefaa58
    // 0xefa9bc: r16 = "11"
    //     0xefa9bc: add             x16, PP, #0x13, lsl #12  ; [pp+0x13728] "11"
    //     0xefa9c0: ldr             x16, [x16, #0x728]
    // 0xefa9c4: ldur            lr, [fp, #-0x18]
    // 0xefa9c8: stp             lr, x16, [SP]
    // 0xefa9cc: r0 = ==()
    //     0xefa9cc: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa9d0: tbnz            w0, #4, #0xefa9e4
    // 0xefa9d4: ldur            x1, [fp, #-8]
    // 0xefa9d8: ldur            x2, [fp, #-0x20]
    // 0xefa9dc: r0 = _handleANCLevel()
    //     0xefa9dc: bl              #0xefad80  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleANCLevel
    // 0xefa9e0: b               #0xefaa58
    // 0xefa9e4: r16 = "12"
    //     0xefa9e4: add             x16, PP, #0x13, lsl #12  ; [pp+0x13730] "12"
    //     0xefa9e8: ldr             x16, [x16, #0x730]
    // 0xefa9ec: ldur            lr, [fp, #-0x18]
    // 0xefa9f0: stp             lr, x16, [SP]
    // 0xefa9f4: r0 = ==()
    //     0xefa9f4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefa9f8: tbnz            w0, #4, #0xefaa0c
    // 0xefa9fc: ldur            x1, [fp, #-8]
    // 0xefaa00: ldur            x2, [fp, #-0x20]
    // 0xefaa04: r0 = _handleTransparencyLevel()
    //     0xefaa04: bl              #0xefac88  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleTransparencyLevel
    // 0xefaa08: b               #0xefaa58
    // 0xefaa0c: r16 = "13"
    //     0xefaa0c: add             x16, PP, #0x13, lsl #12  ; [pp+0x13738] "13"
    //     0xefaa10: ldr             x16, [x16, #0x738]
    // 0xefaa14: ldur            lr, [fp, #-0x18]
    // 0xefaa18: stp             lr, x16, [SP]
    // 0xefaa1c: r0 = ==()
    //     0xefaa1c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefaa20: tbnz            w0, #4, #0xefaa34
    // 0xefaa24: ldur            x1, [fp, #-8]
    // 0xefaa28: ldur            x2, [fp, #-0x20]
    // 0xefaa2c: r0 = _handlePromptToneLevel()
    //     0xefaa2c: bl              #0xefab94  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handlePromptToneLevel
    // 0xefaa30: b               #0xefaa58
    // 0xefaa34: r16 = "16"
    //     0xefaa34: add             x16, PP, #0x13, lsl #12  ; [pp+0x13740] "16"
    //     0xefaa38: ldr             x16, [x16, #0x740]
    // 0xefaa3c: ldur            lr, [fp, #-0x18]
    // 0xefaa40: stp             lr, x16, [SP]
    // 0xefaa44: r0 = ==()
    //     0xefaa44: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefaa48: tbnz            w0, #4, #0xefaa74
    // 0xefaa4c: ldur            x1, [fp, #-8]
    // 0xefaa50: ldur            x2, [fp, #-0x20]
    // 0xefaa54: r0 = _handleTouchControl()
    //     0xefaa54: bl              #0xefaa8c  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleTouchControl
    // 0xefaa58: ldur            x1, [fp, #-8]
    // 0xefaa5c: r2 = true
    //     0xefaa5c: add             x2, NULL, #0x20  ; true
    // 0xefaa60: StoreField: r1->field_b = r2
    //     0xefaa60: stur            w2, [x1, #0xb]
    // 0xefaa64: r0 = Null
    //     0xefaa64: mov             x0, NULL
    // 0xefaa68: LeaveFrame
    //     0xefaa68: mov             SP, fp
    //     0xefaa6c: ldp             fp, lr, [SP], #0x10
    // 0xefaa70: ret
    //     0xefaa70: ret             
    // 0xefaa74: r0 = Null
    //     0xefaa74: mov             x0, NULL
    // 0xefaa78: LeaveFrame
    //     0xefaa78: mov             SP, fp
    //     0xefaa7c: ldp             fp, lr, [SP], #0x10
    // 0xefaa80: ret
    //     0xefaa80: ret             
    // 0xefaa84: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefaa84: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefaa88: b               #0xefa650
  }
  _ _handleTouchControl(/* No info */) {
    // ** addr: 0xefaa8c, size: 0x108
    // 0xefaa8c: EnterFrame
    //     0xefaa8c: stp             fp, lr, [SP, #-0x10]!
    //     0xefaa90: mov             fp, SP
    // 0xefaa94: AllocStack(0x28)
    //     0xefaa94: sub             SP, SP, #0x28
    // 0xefaa98: SetupParameters(F8Receiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefaa98: stur            x1, [fp, #-8]
    //     0xefaa9c: stur            x2, [fp, #-0x10]
    // 0xefaaa0: CheckStackOverflow
    //     0xefaaa0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefaaa4: cmp             SP, x16
    //     0xefaaa8: b.ls            #0xefab80
    // 0xefaaac: r0 = LoadStaticField(0x804)
    //     0xefaaac: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefaab0: ldr             x0, [x0, #0x1008]
    // 0xefaab4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefaab8: cmp             w0, w16
    // 0xefaabc: b.ne            #0xefaac8
    // 0xefaac0: r2 = rsbt
    //     0xefaac0: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefaac4: r0 = InitLateFinalStaticField()
    //     0xefaac4: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefaac8: LoadField: r3 = r0->field_1f
    //     0xefaac8: ldur            w3, [x0, #0x1f]
    // 0xefaacc: DecompressPointer r3
    //     0xefaacc: add             x3, x3, HEAP, lsl #32
    // 0xefaad0: stur            x3, [fp, #-0x18]
    // 0xefaad4: r1 = Null
    //     0xefaad4: mov             x1, NULL
    // 0xefaad8: r2 = 4
    //     0xefaad8: movz            x2, #0x4
    // 0xefaadc: r0 = AllocateArray()
    //     0xefaadc: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefaae0: r16 = "[commander] 触控功能 "
    //     0xefaae0: add             x16, PP, #0x13, lsl #12  ; [pp+0x13388] "[commander] 触控功能 "
    //     0xefaae4: ldr             x16, [x16, #0x388]
    // 0xefaae8: StoreField: r0->field_f = r16
    //     0xefaae8: stur            w16, [x0, #0xf]
    // 0xefaaec: ldur            x1, [fp, #-0x10]
    // 0xefaaf0: StoreField: r0->field_13 = r1
    //     0xefaaf0: stur            w1, [x0, #0x13]
    // 0xefaaf4: str             x0, [SP]
    // 0xefaaf8: r0 = _interpolate()
    //     0xefaaf8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefaafc: ldur            x1, [fp, #-0x18]
    // 0xefab00: mov             x2, x0
    // 0xefab04: r0 = i()
    //     0xefab04: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefab08: ldur            x0, [fp, #-8]
    // 0xefab0c: LoadField: r1 = r0->field_7
    //     0xefab0c: ldur            w1, [x0, #7]
    // 0xefab10: DecompressPointer r1
    //     0xefab10: add             x1, x1, HEAP, lsl #32
    // 0xefab14: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefab18: cmp             w1, w16
    // 0xefab1c: b.eq            #0xefab88
    // 0xefab20: ldur            x0, [fp, #-0x10]
    // 0xefab24: stur            x1, [fp, #-0x18]
    // 0xefab28: r2 = LoadClassIdInstr(r0)
    //     0xefab28: ldur            x2, [x0, #-1]
    //     0xefab2c: ubfx            x2, x2, #0xc, #0x14
    // 0xefab30: r16 = "01"
    //     0xefab30: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc98] "01"
    //     0xefab34: ldr             x16, [x16, #0xc98]
    // 0xefab38: stp             x16, x0, [SP]
    // 0xefab3c: mov             x0, x2
    // 0xefab40: mov             lr, x0
    // 0xefab44: ldr             lr, [x21, lr, lsl #3]
    // 0xefab48: blr             lr
    // 0xefab4c: ldur            x1, [fp, #-0x18]
    // 0xefab50: r2 = LoadClassIdInstr(r1)
    //     0xefab50: ldur            x2, [x1, #-1]
    //     0xefab54: ubfx            x2, x2, #0xc, #0x14
    // 0xefab58: mov             x16, x0
    // 0xefab5c: mov             x0, x2
    // 0xefab60: mov             x2, x16
    // 0xefab64: r0 = GDT[cid_x0 + -0xec2]()
    //     0xefab64: sub             lr, x0, #0xec2
    //     0xefab68: ldr             lr, [x21, lr, lsl #3]
    //     0xefab6c: blr             lr
    // 0xefab70: r0 = Null
    //     0xefab70: mov             x0, NULL
    // 0xefab74: LeaveFrame
    //     0xefab74: mov             SP, fp
    //     0xefab78: ldp             fp, lr, [SP], #0x10
    // 0xefab7c: ret
    //     0xefab7c: ret             
    // 0xefab80: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefab80: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefab84: b               #0xefaaac
    // 0xefab88: r9 = receiveHandler
    //     0xefab88: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefab8c: ldr             x9, [x9, #0x4a8]
    // 0xefab90: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefab90: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handlePromptToneLevel(/* No info */) {
    // ** addr: 0xefab94, size: 0xf4
    // 0xefab94: EnterFrame
    //     0xefab94: stp             fp, lr, [SP, #-0x10]!
    //     0xefab98: mov             fp, SP
    // 0xefab9c: AllocStack(0x20)
    //     0xefab9c: sub             SP, SP, #0x20
    // 0xefaba0: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefaba0: mov             x0, x1
    //     0xefaba4: stur            x1, [fp, #-8]
    //     0xefaba8: mov             x1, x2
    //     0xefabac: stur            x2, [fp, #-0x10]
    // 0xefabb0: CheckStackOverflow
    //     0xefabb0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefabb4: cmp             SP, x16
    //     0xefabb8: b.ls            #0xefac74
    // 0xefabbc: r0 = LoadStaticField(0x804)
    //     0xefabbc: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefabc0: ldr             x0, [x0, #0x1008]
    // 0xefabc4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefabc8: cmp             w0, w16
    // 0xefabcc: b.ne            #0xefabd8
    // 0xefabd0: r2 = rsbt
    //     0xefabd0: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefabd4: r0 = InitLateFinalStaticField()
    //     0xefabd4: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefabd8: LoadField: r3 = r0->field_1f
    //     0xefabd8: ldur            w3, [x0, #0x1f]
    // 0xefabdc: DecompressPointer r3
    //     0xefabdc: add             x3, x3, HEAP, lsl #32
    // 0xefabe0: stur            x3, [fp, #-0x18]
    // 0xefabe4: r1 = Null
    //     0xefabe4: mov             x1, NULL
    // 0xefabe8: r2 = 4
    //     0xefabe8: movz            x2, #0x4
    // 0xefabec: r0 = AllocateArray()
    //     0xefabec: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefabf0: r16 = "[commander] 提示音等级数据获取到了 "
    //     0xefabf0: add             x16, PP, #0x13, lsl #12  ; [pp+0x13328] "[commander] 提示音等级数据获取到了 "
    //     0xefabf4: ldr             x16, [x16, #0x328]
    // 0xefabf8: StoreField: r0->field_f = r16
    //     0xefabf8: stur            w16, [x0, #0xf]
    // 0xefabfc: ldur            x1, [fp, #-0x10]
    // 0xefac00: StoreField: r0->field_13 = r1
    //     0xefac00: stur            w1, [x0, #0x13]
    // 0xefac04: str             x0, [SP]
    // 0xefac08: r0 = _interpolate()
    //     0xefac08: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefac0c: ldur            x1, [fp, #-0x18]
    // 0xefac10: mov             x2, x0
    // 0xefac14: r0 = i()
    //     0xefac14: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefac18: ldur            x0, [fp, #-8]
    // 0xefac1c: LoadField: r2 = r0->field_7
    //     0xefac1c: ldur            w2, [x0, #7]
    // 0xefac20: DecompressPointer r2
    //     0xefac20: add             x2, x2, HEAP, lsl #32
    // 0xefac24: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefac28: cmp             w2, w16
    // 0xefac2c: b.eq            #0xefac7c
    // 0xefac30: ldur            x1, [fp, #-0x10]
    // 0xefac34: stur            x2, [fp, #-0x18]
    // 0xefac38: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefac38: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefac3c: r0 = parse()
    //     0xefac3c: bl              #0x621868  ; [dart:core] int::parse
    // 0xefac40: ldur            x1, [fp, #-0x18]
    // 0xefac44: r2 = LoadClassIdInstr(r1)
    //     0xefac44: ldur            x2, [x1, #-1]
    //     0xefac48: ubfx            x2, x2, #0xc, #0x14
    // 0xefac4c: mov             x16, x0
    // 0xefac50: mov             x0, x2
    // 0xefac54: mov             x2, x16
    // 0xefac58: r0 = GDT[cid_x0 + -0xf61]()
    //     0xefac58: sub             lr, x0, #0xf61
    //     0xefac5c: ldr             lr, [x21, lr, lsl #3]
    //     0xefac60: blr             lr
    // 0xefac64: r0 = Null
    //     0xefac64: mov             x0, NULL
    // 0xefac68: LeaveFrame
    //     0xefac68: mov             SP, fp
    //     0xefac6c: ldp             fp, lr, [SP], #0x10
    // 0xefac70: ret
    //     0xefac70: ret             
    // 0xefac74: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefac74: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefac78: b               #0xefabbc
    // 0xefac7c: r9 = receiveHandler
    //     0xefac7c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefac80: ldr             x9, [x9, #0x4a8]
    // 0xefac84: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefac84: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleTransparencyLevel(/* No info */) {
    // ** addr: 0xefac88, size: 0xf8
    // 0xefac88: EnterFrame
    //     0xefac88: stp             fp, lr, [SP, #-0x10]!
    //     0xefac8c: mov             fp, SP
    // 0xefac90: AllocStack(0x20)
    //     0xefac90: sub             SP, SP, #0x20
    // 0xefac94: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefac94: mov             x0, x1
    //     0xefac98: stur            x1, [fp, #-8]
    //     0xefac9c: mov             x1, x2
    //     0xefaca0: stur            x2, [fp, #-0x10]
    // 0xefaca4: CheckStackOverflow
    //     0xefaca4: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefaca8: cmp             SP, x16
    //     0xefacac: b.ls            #0xefad6c
    // 0xefacb0: r0 = LoadStaticField(0x804)
    //     0xefacb0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefacb4: ldr             x0, [x0, #0x1008]
    // 0xefacb8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefacbc: cmp             w0, w16
    // 0xefacc0: b.ne            #0xefaccc
    // 0xefacc4: r2 = rsbt
    //     0xefacc4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefacc8: r0 = InitLateFinalStaticField()
    //     0xefacc8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefaccc: LoadField: r3 = r0->field_1f
    //     0xefaccc: ldur            w3, [x0, #0x1f]
    // 0xefacd0: DecompressPointer r3
    //     0xefacd0: add             x3, x3, HEAP, lsl #32
    // 0xefacd4: stur            x3, [fp, #-0x18]
    // 0xefacd8: r1 = Null
    //     0xefacd8: mov             x1, NULL
    // 0xefacdc: r2 = 4
    //     0xefacdc: movz            x2, #0x4
    // 0xeface0: r0 = AllocateArray()
    //     0xeface0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xeface4: r16 = "[commander] 通透等级数据获取到了 "
    //     0xeface4: add             x16, PP, #0x13, lsl #12  ; [pp+0x13330] "[commander] 通透等级数据获取到了 "
    //     0xeface8: ldr             x16, [x16, #0x330]
    // 0xefacec: StoreField: r0->field_f = r16
    //     0xefacec: stur            w16, [x0, #0xf]
    // 0xefacf0: ldur            x1, [fp, #-0x10]
    // 0xefacf4: StoreField: r0->field_13 = r1
    //     0xefacf4: stur            w1, [x0, #0x13]
    // 0xefacf8: str             x0, [SP]
    // 0xefacfc: r0 = _interpolate()
    //     0xefacfc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefad00: ldur            x1, [fp, #-0x18]
    // 0xefad04: mov             x2, x0
    // 0xefad08: r0 = i()
    //     0xefad08: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefad0c: ldur            x0, [fp, #-8]
    // 0xefad10: LoadField: r2 = r0->field_7
    //     0xefad10: ldur            w2, [x0, #7]
    // 0xefad14: DecompressPointer r2
    //     0xefad14: add             x2, x2, HEAP, lsl #32
    // 0xefad18: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefad1c: cmp             w2, w16
    // 0xefad20: b.eq            #0xefad74
    // 0xefad24: ldur            x1, [fp, #-0x10]
    // 0xefad28: stur            x2, [fp, #-0x18]
    // 0xefad2c: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefad2c: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefad30: r0 = parse()
    //     0xefad30: bl              #0x621868  ; [dart:core] int::parse
    // 0xefad34: ldur            x1, [fp, #-0x18]
    // 0xefad38: r2 = LoadClassIdInstr(r1)
    //     0xefad38: ldur            x2, [x1, #-1]
    //     0xefad3c: ubfx            x2, x2, #0xc, #0x14
    // 0xefad40: mov             x16, x0
    // 0xefad44: mov             x0, x2
    // 0xefad48: mov             x2, x16
    // 0xefad4c: ldur            x3, [fp, #-0x10]
    // 0xefad50: r0 = GDT[cid_x0 + -0xb60]()
    //     0xefad50: sub             lr, x0, #0xb60
    //     0xefad54: ldr             lr, [x21, lr, lsl #3]
    //     0xefad58: blr             lr
    // 0xefad5c: r0 = Null
    //     0xefad5c: mov             x0, NULL
    // 0xefad60: LeaveFrame
    //     0xefad60: mov             SP, fp
    //     0xefad64: ldp             fp, lr, [SP], #0x10
    // 0xefad68: ret
    //     0xefad68: ret             
    // 0xefad6c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefad6c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefad70: b               #0xefacb0
    // 0xefad74: r9 = receiveHandler
    //     0xefad74: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefad78: ldr             x9, [x9, #0x4a8]
    // 0xefad7c: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefad7c: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleANCLevel(/* No info */) {
    // ** addr: 0xefad80, size: 0xf8
    // 0xefad80: EnterFrame
    //     0xefad80: stp             fp, lr, [SP, #-0x10]!
    //     0xefad84: mov             fp, SP
    // 0xefad88: AllocStack(0x20)
    //     0xefad88: sub             SP, SP, #0x20
    // 0xefad8c: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefad8c: mov             x0, x1
    //     0xefad90: stur            x1, [fp, #-8]
    //     0xefad94: mov             x1, x2
    //     0xefad98: stur            x2, [fp, #-0x10]
    // 0xefad9c: CheckStackOverflow
    //     0xefad9c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefada0: cmp             SP, x16
    //     0xefada4: b.ls            #0xefae64
    // 0xefada8: r0 = LoadStaticField(0x804)
    //     0xefada8: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefadac: ldr             x0, [x0, #0x1008]
    // 0xefadb0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefadb4: cmp             w0, w16
    // 0xefadb8: b.ne            #0xefadc4
    // 0xefadbc: r2 = rsbt
    //     0xefadbc: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefadc0: r0 = InitLateFinalStaticField()
    //     0xefadc0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefadc4: LoadField: r3 = r0->field_1f
    //     0xefadc4: ldur            w3, [x0, #0x1f]
    // 0xefadc8: DecompressPointer r3
    //     0xefadc8: add             x3, x3, HEAP, lsl #32
    // 0xefadcc: stur            x3, [fp, #-0x18]
    // 0xefadd0: r1 = Null
    //     0xefadd0: mov             x1, NULL
    // 0xefadd4: r2 = 4
    //     0xefadd4: movz            x2, #0x4
    // 0xefadd8: r0 = AllocateArray()
    //     0xefadd8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefaddc: r16 = "[commander] 降噪等级数据获取到了 "
    //     0xefaddc: add             x16, PP, #0x13, lsl #12  ; [pp+0x13338] "[commander] 降噪等级数据获取到了 "
    //     0xefade0: ldr             x16, [x16, #0x338]
    // 0xefade4: StoreField: r0->field_f = r16
    //     0xefade4: stur            w16, [x0, #0xf]
    // 0xefade8: ldur            x1, [fp, #-0x10]
    // 0xefadec: StoreField: r0->field_13 = r1
    //     0xefadec: stur            w1, [x0, #0x13]
    // 0xefadf0: str             x0, [SP]
    // 0xefadf4: r0 = _interpolate()
    //     0xefadf4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefadf8: ldur            x1, [fp, #-0x18]
    // 0xefadfc: mov             x2, x0
    // 0xefae00: r0 = i()
    //     0xefae00: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefae04: ldur            x0, [fp, #-8]
    // 0xefae08: LoadField: r2 = r0->field_7
    //     0xefae08: ldur            w2, [x0, #7]
    // 0xefae0c: DecompressPointer r2
    //     0xefae0c: add             x2, x2, HEAP, lsl #32
    // 0xefae10: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefae14: cmp             w2, w16
    // 0xefae18: b.eq            #0xefae6c
    // 0xefae1c: ldur            x1, [fp, #-0x10]
    // 0xefae20: stur            x2, [fp, #-0x18]
    // 0xefae24: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefae24: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefae28: r0 = parse()
    //     0xefae28: bl              #0x621868  ; [dart:core] int::parse
    // 0xefae2c: ldur            x1, [fp, #-0x18]
    // 0xefae30: r2 = LoadClassIdInstr(r1)
    //     0xefae30: ldur            x2, [x1, #-1]
    //     0xefae34: ubfx            x2, x2, #0xc, #0x14
    // 0xefae38: mov             x16, x0
    // 0xefae3c: mov             x0, x2
    // 0xefae40: mov             x2, x16
    // 0xefae44: ldur            x3, [fp, #-0x10]
    // 0xefae48: r0 = GDT[cid_x0 + -0xb6e]()
    //     0xefae48: sub             lr, x0, #0xb6e
    //     0xefae4c: ldr             lr, [x21, lr, lsl #3]
    //     0xefae50: blr             lr
    // 0xefae54: r0 = Null
    //     0xefae54: mov             x0, NULL
    // 0xefae58: LeaveFrame
    //     0xefae58: mov             SP, fp
    //     0xefae5c: ldp             fp, lr, [SP], #0x10
    // 0xefae60: ret
    //     0xefae60: ret             
    // 0xefae64: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefae64: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefae68: b               #0xefada8
    // 0xefae6c: r9 = receiveHandler
    //     0xefae6c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefae70: ldr             x9, [x9, #0x4a8]
    // 0xefae74: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefae74: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleANCData(/* No info */) {
    // ** addr: 0xefae78, size: 0xf8
    // 0xefae78: EnterFrame
    //     0xefae78: stp             fp, lr, [SP, #-0x10]!
    //     0xefae7c: mov             fp, SP
    // 0xefae80: AllocStack(0x20)
    //     0xefae80: sub             SP, SP, #0x20
    // 0xefae84: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefae84: mov             x0, x1
    //     0xefae88: stur            x1, [fp, #-8]
    //     0xefae8c: mov             x1, x2
    //     0xefae90: stur            x2, [fp, #-0x10]
    // 0xefae94: CheckStackOverflow
    //     0xefae94: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefae98: cmp             SP, x16
    //     0xefae9c: b.ls            #0xefaf5c
    // 0xefaea0: r0 = LoadStaticField(0x804)
    //     0xefaea0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefaea4: ldr             x0, [x0, #0x1008]
    // 0xefaea8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefaeac: cmp             w0, w16
    // 0xefaeb0: b.ne            #0xefaebc
    // 0xefaeb4: r2 = rsbt
    //     0xefaeb4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefaeb8: r0 = InitLateFinalStaticField()
    //     0xefaeb8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefaebc: LoadField: r3 = r0->field_1f
    //     0xefaebc: ldur            w3, [x0, #0x1f]
    // 0xefaec0: DecompressPointer r3
    //     0xefaec0: add             x3, x3, HEAP, lsl #32
    // 0xefaec4: stur            x3, [fp, #-0x18]
    // 0xefaec8: r1 = Null
    //     0xefaec8: mov             x1, NULL
    // 0xefaecc: r2 = 4
    //     0xefaecc: movz            x2, #0x4
    // 0xefaed0: r0 = AllocateArray()
    //     0xefaed0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefaed4: r16 = "[commander] 降噪数据获取到了 "
    //     0xefaed4: add             x16, PP, #0x13, lsl #12  ; [pp+0x133d8] "[commander] 降噪数据获取到了 "
    //     0xefaed8: ldr             x16, [x16, #0x3d8]
    // 0xefaedc: StoreField: r0->field_f = r16
    //     0xefaedc: stur            w16, [x0, #0xf]
    // 0xefaee0: ldur            x1, [fp, #-0x10]
    // 0xefaee4: StoreField: r0->field_13 = r1
    //     0xefaee4: stur            w1, [x0, #0x13]
    // 0xefaee8: str             x0, [SP]
    // 0xefaeec: r0 = _interpolate()
    //     0xefaeec: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefaef0: ldur            x1, [fp, #-0x18]
    // 0xefaef4: mov             x2, x0
    // 0xefaef8: r0 = i()
    //     0xefaef8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefaefc: ldur            x0, [fp, #-8]
    // 0xefaf00: LoadField: r2 = r0->field_7
    //     0xefaf00: ldur            w2, [x0, #7]
    // 0xefaf04: DecompressPointer r2
    //     0xefaf04: add             x2, x2, HEAP, lsl #32
    // 0xefaf08: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefaf0c: cmp             w2, w16
    // 0xefaf10: b.eq            #0xefaf64
    // 0xefaf14: ldur            x1, [fp, #-0x10]
    // 0xefaf18: stur            x2, [fp, #-0x18]
    // 0xefaf1c: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefaf1c: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefaf20: r0 = parse()
    //     0xefaf20: bl              #0x621868  ; [dart:core] int::parse
    // 0xefaf24: ldur            x1, [fp, #-0x18]
    // 0xefaf28: r2 = LoadClassIdInstr(r1)
    //     0xefaf28: ldur            x2, [x1, #-1]
    //     0xefaf2c: ubfx            x2, x2, #0xc, #0x14
    // 0xefaf30: mov             x16, x0
    // 0xefaf34: mov             x0, x2
    // 0xefaf38: mov             x2, x16
    // 0xefaf3c: ldur            x3, [fp, #-0x10]
    // 0xefaf40: r0 = GDT[cid_x0 + -0xf0b]()
    //     0xefaf40: sub             lr, x0, #0xf0b
    //     0xefaf44: ldr             lr, [x21, lr, lsl #3]
    //     0xefaf48: blr             lr
    // 0xefaf4c: r0 = Null
    //     0xefaf4c: mov             x0, NULL
    // 0xefaf50: LeaveFrame
    //     0xefaf50: mov             SP, fp
    //     0xefaf54: ldp             fp, lr, [SP], #0x10
    // 0xefaf58: ret
    //     0xefaf58: ret             
    // 0xefaf5c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefaf5c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefaf60: b               #0xefaea0
    // 0xefaf64: r9 = receiveHandler
    //     0xefaf64: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefaf68: ldr             x9, [x9, #0x4a8]
    // 0xefaf6c: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefaf6c: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleConnectionMode(/* No info */) {
    // ** addr: 0xefaf70, size: 0xf4
    // 0xefaf70: EnterFrame
    //     0xefaf70: stp             fp, lr, [SP, #-0x10]!
    //     0xefaf74: mov             fp, SP
    // 0xefaf78: AllocStack(0x20)
    //     0xefaf78: sub             SP, SP, #0x20
    // 0xefaf7c: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefaf7c: mov             x0, x1
    //     0xefaf80: stur            x1, [fp, #-8]
    //     0xefaf84: mov             x1, x2
    //     0xefaf88: stur            x2, [fp, #-0x10]
    // 0xefaf8c: CheckStackOverflow
    //     0xefaf8c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefaf90: cmp             SP, x16
    //     0xefaf94: b.ls            #0xefb050
    // 0xefaf98: r0 = LoadStaticField(0x804)
    //     0xefaf98: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefaf9c: ldr             x0, [x0, #0x1008]
    // 0xefafa0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefafa4: cmp             w0, w16
    // 0xefafa8: b.ne            #0xefafb4
    // 0xefafac: r2 = rsbt
    //     0xefafac: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefafb0: r0 = InitLateFinalStaticField()
    //     0xefafb0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefafb4: LoadField: r3 = r0->field_1f
    //     0xefafb4: ldur            w3, [x0, #0x1f]
    // 0xefafb8: DecompressPointer r3
    //     0xefafb8: add             x3, x3, HEAP, lsl #32
    // 0xefafbc: stur            x3, [fp, #-0x18]
    // 0xefafc0: r1 = Null
    //     0xefafc0: mov             x1, NULL
    // 0xefafc4: r2 = 4
    //     0xefafc4: movz            x2, #0x4
    // 0xefafc8: r0 = AllocateArray()
    //     0xefafc8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefafcc: r16 = "[commander] 当前耳机支持模式为 "
    //     0xefafcc: add             x16, PP, #0x13, lsl #12  ; [pp+0x13350] "[commander] 当前耳机支持模式为 "
    //     0xefafd0: ldr             x16, [x16, #0x350]
    // 0xefafd4: StoreField: r0->field_f = r16
    //     0xefafd4: stur            w16, [x0, #0xf]
    // 0xefafd8: ldur            x1, [fp, #-0x10]
    // 0xefafdc: StoreField: r0->field_13 = r1
    //     0xefafdc: stur            w1, [x0, #0x13]
    // 0xefafe0: str             x0, [SP]
    // 0xefafe4: r0 = _interpolate()
    //     0xefafe4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefafe8: ldur            x1, [fp, #-0x18]
    // 0xefafec: mov             x2, x0
    // 0xefaff0: r0 = i()
    //     0xefaff0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefaff4: ldur            x0, [fp, #-8]
    // 0xefaff8: LoadField: r2 = r0->field_7
    //     0xefaff8: ldur            w2, [x0, #7]
    // 0xefaffc: DecompressPointer r2
    //     0xefaffc: add             x2, x2, HEAP, lsl #32
    // 0xefb000: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb004: cmp             w2, w16
    // 0xefb008: b.eq            #0xefb058
    // 0xefb00c: ldur            x1, [fp, #-0x10]
    // 0xefb010: stur            x2, [fp, #-0x18]
    // 0xefb014: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefb014: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefb018: r0 = parse()
    //     0xefb018: bl              #0x621868  ; [dart:core] int::parse
    // 0xefb01c: ldur            x1, [fp, #-0x18]
    // 0xefb020: r2 = LoadClassIdInstr(r1)
    //     0xefb020: ldur            x2, [x1, #-1]
    //     0xefb024: ubfx            x2, x2, #0xc, #0x14
    // 0xefb028: mov             x16, x0
    // 0xefb02c: mov             x0, x2
    // 0xefb030: mov             x2, x16
    // 0xefb034: r0 = GDT[cid_x0 + -0xb7c]()
    //     0xefb034: sub             lr, x0, #0xb7c
    //     0xefb038: ldr             lr, [x21, lr, lsl #3]
    //     0xefb03c: blr             lr
    // 0xefb040: r0 = Null
    //     0xefb040: mov             x0, NULL
    // 0xefb044: LeaveFrame
    //     0xefb044: mov             SP, fp
    //     0xefb048: ldp             fp, lr, [SP], #0x10
    // 0xefb04c: ret
    //     0xefb04c: ret             
    // 0xefb050: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb050: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb054: b               #0xefaf98
    // 0xefb058: r9 = receiveHandler
    //     0xefb058: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb05c: ldr             x9, [x9, #0x4a8]
    // 0xefb060: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb060: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleEarLanguage(/* No info */) {
    // ** addr: 0xefb064, size: 0x104
    // 0xefb064: EnterFrame
    //     0xefb064: stp             fp, lr, [SP, #-0x10]!
    //     0xefb068: mov             fp, SP
    // 0xefb06c: AllocStack(0x20)
    //     0xefb06c: sub             SP, SP, #0x20
    // 0xefb070: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1 */)
    //     0xefb070: mov             x0, x1
    //     0xefb074: stur            x1, [fp, #-8]
    //     0xefb078: mov             x1, x2
    // 0xefb07c: CheckStackOverflow
    //     0xefb07c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb080: cmp             SP, x16
    //     0xefb084: b.ls            #0xefb154
    // 0xefb088: r16 = 32
    //     0xefb088: movz            x16, #0x20
    // 0xefb08c: str             x16, [SP]
    // 0xefb090: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefb090: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefb094: ldr             x4, [x4, #0x128]
    // 0xefb098: r0 = parse()
    //     0xefb098: bl              #0x621868  ; [dart:core] int::parse
    // 0xefb09c: stur            x0, [fp, #-0x10]
    // 0xefb0a0: r0 = LoadStaticField(0x804)
    //     0xefb0a0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb0a4: ldr             x0, [x0, #0x1008]
    // 0xefb0a8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb0ac: cmp             w0, w16
    // 0xefb0b0: b.ne            #0xefb0bc
    // 0xefb0b4: r2 = rsbt
    //     0xefb0b4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb0b8: r0 = InitLateFinalStaticField()
    //     0xefb0b8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb0bc: LoadField: r3 = r0->field_1f
    //     0xefb0bc: ldur            w3, [x0, #0x1f]
    // 0xefb0c0: DecompressPointer r3
    //     0xefb0c0: add             x3, x3, HEAP, lsl #32
    // 0xefb0c4: stur            x3, [fp, #-0x18]
    // 0xefb0c8: r1 = Null
    //     0xefb0c8: mov             x1, NULL
    // 0xefb0cc: r2 = 4
    //     0xefb0cc: movz            x2, #0x4
    // 0xefb0d0: r0 = AllocateArray()
    //     0xefb0d0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb0d4: mov             x2, x0
    // 0xefb0d8: r16 = "[commander] 语音语言偏好 "
    //     0xefb0d8: add             x16, PP, #0x13, lsl #12  ; [pp+0x13748] "[commander] 语音语言偏好 "
    //     0xefb0dc: ldr             x16, [x16, #0x748]
    // 0xefb0e0: StoreField: r2->field_f = r16
    //     0xefb0e0: stur            w16, [x2, #0xf]
    // 0xefb0e4: ldur            x3, [fp, #-0x10]
    // 0xefb0e8: r0 = BoxInt64Instr(r3)
    //     0xefb0e8: sbfiz           x0, x3, #1, #0x1f
    //     0xefb0ec: cmp             x3, x0, asr #1
    //     0xefb0f0: b.eq            #0xefb0fc
    //     0xefb0f4: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefb0f8: stur            x3, [x0, #7]
    // 0xefb0fc: StoreField: r2->field_13 = r0
    //     0xefb0fc: stur            w0, [x2, #0x13]
    // 0xefb100: str             x2, [SP]
    // 0xefb104: r0 = _interpolate()
    //     0xefb104: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb108: ldur            x1, [fp, #-0x18]
    // 0xefb10c: mov             x2, x0
    // 0xefb110: r0 = i()
    //     0xefb110: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb114: ldur            x0, [fp, #-8]
    // 0xefb118: LoadField: r1 = r0->field_7
    //     0xefb118: ldur            w1, [x0, #7]
    // 0xefb11c: DecompressPointer r1
    //     0xefb11c: add             x1, x1, HEAP, lsl #32
    // 0xefb120: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb124: cmp             w1, w16
    // 0xefb128: b.eq            #0xefb15c
    // 0xefb12c: r0 = LoadClassIdInstr(r1)
    //     0xefb12c: ldur            x0, [x1, #-1]
    //     0xefb130: ubfx            x0, x0, #0xc, #0x14
    // 0xefb134: ldur            x2, [fp, #-0x10]
    // 0xefb138: r0 = GDT[cid_x0 + -0x9e6]()
    //     0xefb138: sub             lr, x0, #0x9e6
    //     0xefb13c: ldr             lr, [x21, lr, lsl #3]
    //     0xefb140: blr             lr
    // 0xefb144: r0 = Null
    //     0xefb144: mov             x0, NULL
    // 0xefb148: LeaveFrame
    //     0xefb148: mov             SP, fp
    //     0xefb14c: ldp             fp, lr, [SP], #0x10
    // 0xefb150: ret
    //     0xefb150: ret             
    // 0xefb154: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb154: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb158: b               #0xefb088
    // 0xefb15c: r9 = receiveHandler
    //     0xefb15c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb160: ldr             x9, [x9, #0x4a8]
    // 0xefb164: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb164: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleInEarDetection(/* No info */) {
    // ** addr: 0xefb168, size: 0x108
    // 0xefb168: EnterFrame
    //     0xefb168: stp             fp, lr, [SP, #-0x10]!
    //     0xefb16c: mov             fp, SP
    // 0xefb170: AllocStack(0x28)
    //     0xefb170: sub             SP, SP, #0x28
    // 0xefb174: SetupParameters(F8Receiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefb174: stur            x1, [fp, #-8]
    //     0xefb178: stur            x2, [fp, #-0x10]
    // 0xefb17c: CheckStackOverflow
    //     0xefb17c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb180: cmp             SP, x16
    //     0xefb184: b.ls            #0xefb25c
    // 0xefb188: r0 = LoadStaticField(0x804)
    //     0xefb188: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb18c: ldr             x0, [x0, #0x1008]
    // 0xefb190: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb194: cmp             w0, w16
    // 0xefb198: b.ne            #0xefb1a4
    // 0xefb19c: r2 = rsbt
    //     0xefb19c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb1a0: r0 = InitLateFinalStaticField()
    //     0xefb1a0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb1a4: LoadField: r3 = r0->field_1f
    //     0xefb1a4: ldur            w3, [x0, #0x1f]
    // 0xefb1a8: DecompressPointer r3
    //     0xefb1a8: add             x3, x3, HEAP, lsl #32
    // 0xefb1ac: stur            x3, [fp, #-0x18]
    // 0xefb1b0: r1 = Null
    //     0xefb1b0: mov             x1, NULL
    // 0xefb1b4: r2 = 4
    //     0xefb1b4: movz            x2, #0x4
    // 0xefb1b8: r0 = AllocateArray()
    //     0xefb1b8: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb1bc: r16 = "[commander] 入耳检测 "
    //     0xefb1bc: add             x16, PP, #0x13, lsl #12  ; [pp+0x13378] "[commander] 入耳检测 "
    //     0xefb1c0: ldr             x16, [x16, #0x378]
    // 0xefb1c4: StoreField: r0->field_f = r16
    //     0xefb1c4: stur            w16, [x0, #0xf]
    // 0xefb1c8: ldur            x1, [fp, #-0x10]
    // 0xefb1cc: StoreField: r0->field_13 = r1
    //     0xefb1cc: stur            w1, [x0, #0x13]
    // 0xefb1d0: str             x0, [SP]
    // 0xefb1d4: r0 = _interpolate()
    //     0xefb1d4: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb1d8: ldur            x1, [fp, #-0x18]
    // 0xefb1dc: mov             x2, x0
    // 0xefb1e0: r0 = i()
    //     0xefb1e0: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb1e4: ldur            x0, [fp, #-8]
    // 0xefb1e8: LoadField: r1 = r0->field_7
    //     0xefb1e8: ldur            w1, [x0, #7]
    // 0xefb1ec: DecompressPointer r1
    //     0xefb1ec: add             x1, x1, HEAP, lsl #32
    // 0xefb1f0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb1f4: cmp             w1, w16
    // 0xefb1f8: b.eq            #0xefb264
    // 0xefb1fc: ldur            x0, [fp, #-0x10]
    // 0xefb200: stur            x1, [fp, #-0x18]
    // 0xefb204: r2 = LoadClassIdInstr(r0)
    //     0xefb204: ldur            x2, [x0, #-1]
    //     0xefb208: ubfx            x2, x2, #0xc, #0x14
    // 0xefb20c: r16 = "1"
    //     0xefb20c: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefb210: ldr             x16, [x16, #0x248]
    // 0xefb214: stp             x16, x0, [SP]
    // 0xefb218: mov             x0, x2
    // 0xefb21c: mov             lr, x0
    // 0xefb220: ldr             lr, [x21, lr, lsl #3]
    // 0xefb224: blr             lr
    // 0xefb228: ldur            x1, [fp, #-0x18]
    // 0xefb22c: r2 = LoadClassIdInstr(r1)
    //     0xefb22c: ldur            x2, [x1, #-1]
    //     0xefb230: ubfx            x2, x2, #0xc, #0x14
    // 0xefb234: mov             x16, x0
    // 0xefb238: mov             x0, x2
    // 0xefb23c: mov             x2, x16
    // 0xefb240: r0 = GDT[cid_x0 + -0xeb4]()
    //     0xefb240: sub             lr, x0, #0xeb4
    //     0xefb244: ldr             lr, [x21, lr, lsl #3]
    //     0xefb248: blr             lr
    // 0xefb24c: r0 = Null
    //     0xefb24c: mov             x0, NULL
    // 0xefb250: LeaveFrame
    //     0xefb250: mov             SP, fp
    //     0xefb254: ldp             fp, lr, [SP], #0x10
    // 0xefb258: ret
    //     0xefb258: ret             
    // 0xefb25c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb25c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb260: b               #0xefb188
    // 0xefb264: r9 = receiveHandler
    //     0xefb264: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb268: ldr             x9, [x9, #0x4a8]
    // 0xefb26c: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb26c: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleGameMode(/* No info */) {
    // ** addr: 0xefb270, size: 0x108
    // 0xefb270: EnterFrame
    //     0xefb270: stp             fp, lr, [SP, #-0x10]!
    //     0xefb274: mov             fp, SP
    // 0xefb278: AllocStack(0x28)
    //     0xefb278: sub             SP, SP, #0x28
    // 0xefb27c: SetupParameters(F8Receiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefb27c: stur            x1, [fp, #-8]
    //     0xefb280: stur            x2, [fp, #-0x10]
    // 0xefb284: CheckStackOverflow
    //     0xefb284: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb288: cmp             SP, x16
    //     0xefb28c: b.ls            #0xefb364
    // 0xefb290: r0 = LoadStaticField(0x804)
    //     0xefb290: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb294: ldr             x0, [x0, #0x1008]
    // 0xefb298: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb29c: cmp             w0, w16
    // 0xefb2a0: b.ne            #0xefb2ac
    // 0xefb2a4: r2 = rsbt
    //     0xefb2a4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb2a8: r0 = InitLateFinalStaticField()
    //     0xefb2a8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb2ac: LoadField: r3 = r0->field_1f
    //     0xefb2ac: ldur            w3, [x0, #0x1f]
    // 0xefb2b0: DecompressPointer r3
    //     0xefb2b0: add             x3, x3, HEAP, lsl #32
    // 0xefb2b4: stur            x3, [fp, #-0x18]
    // 0xefb2b8: r1 = Null
    //     0xefb2b8: mov             x1, NULL
    // 0xefb2bc: r2 = 4
    //     0xefb2bc: movz            x2, #0x4
    // 0xefb2c0: r0 = AllocateArray()
    //     0xefb2c0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb2c4: r16 = "[commander] 游戏模式 "
    //     0xefb2c4: add             x16, PP, #0x13, lsl #12  ; [pp+0x13358] "[commander] 游戏模式 "
    //     0xefb2c8: ldr             x16, [x16, #0x358]
    // 0xefb2cc: StoreField: r0->field_f = r16
    //     0xefb2cc: stur            w16, [x0, #0xf]
    // 0xefb2d0: ldur            x1, [fp, #-0x10]
    // 0xefb2d4: StoreField: r0->field_13 = r1
    //     0xefb2d4: stur            w1, [x0, #0x13]
    // 0xefb2d8: str             x0, [SP]
    // 0xefb2dc: r0 = _interpolate()
    //     0xefb2dc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb2e0: ldur            x1, [fp, #-0x18]
    // 0xefb2e4: mov             x2, x0
    // 0xefb2e8: r0 = i()
    //     0xefb2e8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb2ec: ldur            x0, [fp, #-8]
    // 0xefb2f0: LoadField: r1 = r0->field_7
    //     0xefb2f0: ldur            w1, [x0, #7]
    // 0xefb2f4: DecompressPointer r1
    //     0xefb2f4: add             x1, x1, HEAP, lsl #32
    // 0xefb2f8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb2fc: cmp             w1, w16
    // 0xefb300: b.eq            #0xefb36c
    // 0xefb304: ldur            x0, [fp, #-0x10]
    // 0xefb308: stur            x1, [fp, #-0x18]
    // 0xefb30c: r2 = LoadClassIdInstr(r0)
    //     0xefb30c: ldur            x2, [x0, #-1]
    //     0xefb310: ubfx            x2, x2, #0xc, #0x14
    // 0xefb314: r16 = "01"
    //     0xefb314: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc98] "01"
    //     0xefb318: ldr             x16, [x16, #0xc98]
    // 0xefb31c: stp             x16, x0, [SP]
    // 0xefb320: mov             x0, x2
    // 0xefb324: mov             lr, x0
    // 0xefb328: ldr             lr, [x21, lr, lsl #3]
    // 0xefb32c: blr             lr
    // 0xefb330: ldur            x1, [fp, #-0x18]
    // 0xefb334: r2 = LoadClassIdInstr(r1)
    //     0xefb334: ldur            x2, [x1, #-1]
    //     0xefb338: ubfx            x2, x2, #0xc, #0x14
    // 0xefb33c: mov             x16, x0
    // 0xefb340: mov             x0, x2
    // 0xefb344: mov             x2, x16
    // 0xefb348: r0 = GDT[cid_x0 + -0xb8a]()
    //     0xefb348: sub             lr, x0, #0xb8a
    //     0xefb34c: ldr             lr, [x21, lr, lsl #3]
    //     0xefb350: blr             lr
    // 0xefb354: r0 = Null
    //     0xefb354: mov             x0, NULL
    // 0xefb358: LeaveFrame
    //     0xefb358: mov             SP, fp
    //     0xefb35c: ldp             fp, lr, [SP], #0x10
    // 0xefb360: ret
    //     0xefb360: ret             
    // 0xefb364: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb364: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb368: b               #0xefb290
    // 0xefb36c: r9 = receiveHandler
    //     0xefb36c: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb370: ldr             x9, [x9, #0x4a8]
    // 0xefb374: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb374: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleKeyData(/* No info */) {
    // ** addr: 0xefb378, size: 0x19c
    // 0xefb378: EnterFrame
    //     0xefb378: stp             fp, lr, [SP, #-0x10]!
    //     0xefb37c: mov             fp, SP
    // 0xefb380: AllocStack(0x78)
    //     0xefb380: sub             SP, SP, #0x78
    // 0xefb384: SetupParameters(F8Receiver this /* r1 => r1, fp-0x48 */, dynamic _ /* r2 => r2, fp-0x50 */)
    //     0xefb384: stur            x1, [fp, #-0x48]
    //     0xefb388: stur            x2, [fp, #-0x50]
    // 0xefb38c: CheckStackOverflow
    //     0xefb38c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb390: cmp             SP, x16
    //     0xefb394: b.ls            #0xefb500
    // 0xefb398: r1 = 1
    //     0xefb398: movz            x1, #0x1
    // 0xefb39c: r0 = AllocateContext()
    //     0xefb39c: bl              #0xf1dacc  ; AllocateContextStub
    // 0xefb3a0: mov             x1, x0
    // 0xefb3a4: ldur            x0, [fp, #-0x50]
    // 0xefb3a8: stur            x1, [fp, #-0x58]
    // 0xefb3ac: StoreField: r1->field_f = r0
    //     0xefb3ac: stur            w0, [x1, #0xf]
    // 0xefb3b0: r0 = LoadStaticField(0x804)
    //     0xefb3b0: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb3b4: ldr             x0, [x0, #0x1008]
    // 0xefb3b8: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb3bc: cmp             w0, w16
    // 0xefb3c0: b.ne            #0xefb3cc
    // 0xefb3c4: r2 = rsbt
    //     0xefb3c4: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb3c8: r0 = InitLateFinalStaticField()
    //     0xefb3c8: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb3cc: stur            x0, [fp, #-0x60]
    // 0xefb3d0: LoadField: r3 = r0->field_1f
    //     0xefb3d0: ldur            w3, [x0, #0x1f]
    // 0xefb3d4: DecompressPointer r3
    //     0xefb3d4: add             x3, x3, HEAP, lsl #32
    // 0xefb3d8: stur            x3, [fp, #-0x50]
    // 0xefb3dc: r1 = Null
    //     0xefb3dc: mov             x1, NULL
    // 0xefb3e0: r2 = 4
    //     0xefb3e0: movz            x2, #0x4
    // 0xefb3e4: r0 = AllocateArray()
    //     0xefb3e4: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb3e8: r16 = "[commander] 按键数据获取到了 "
    //     0xefb3e8: add             x16, PP, #0x13, lsl #12  ; [pp+0x13398] "[commander] 按键数据获取到了 "
    //     0xefb3ec: ldr             x16, [x16, #0x398]
    // 0xefb3f0: StoreField: r0->field_f = r16
    //     0xefb3f0: stur            w16, [x0, #0xf]
    // 0xefb3f4: ldur            x2, [fp, #-0x58]
    // 0xefb3f8: LoadField: r1 = r2->field_f
    //     0xefb3f8: ldur            w1, [x2, #0xf]
    // 0xefb3fc: DecompressPointer r1
    //     0xefb3fc: add             x1, x1, HEAP, lsl #32
    // 0xefb400: StoreField: r0->field_13 = r1
    //     0xefb400: stur            w1, [x0, #0x13]
    // 0xefb404: str             x0, [SP]
    // 0xefb408: r0 = _interpolate()
    //     0xefb408: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb40c: ldur            x1, [fp, #-0x50]
    // 0xefb410: mov             x2, x0
    // 0xefb414: r0 = i()
    //     0xefb414: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb418: ldur            x3, [fp, #-0x48]
    // 0xefb41c: ldur            x0, [fp, #-0x58]
    // 0xefb420: mov             x2, x0
    // 0xefb424: r1 = Function '<anonymous closure>':.
    //     0xefb424: add             x1, PP, #0x13, lsl #12  ; [pp+0x13750] AnonymousClosure: (0xefb514), in [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleKeyData (0xefb630)
    //     0xefb428: ldr             x1, [x1, #0x750]
    // 0xefb42c: r0 = AllocateClosure()
    //     0xefb42c: bl              #0xf1dea0  ; AllocateClosureStub
    // 0xefb430: r16 = <int>
    //     0xefb430: ldr             x16, [PP, #0x988]  ; [pp+0x988] TypeArguments: <int>
    // 0xefb434: r30 = const [0xf, 0x13, 0x17, 0x11, 0x15, 0x19]
    //     0xefb434: add             lr, PP, #0x13, lsl #12  ; [pp+0x13758] List<int>(6)
    //     0xefb438: ldr             lr, [lr, #0x758]
    // 0xefb43c: stp             lr, x16, [SP, #8]
    // 0xefb440: str             x0, [SP]
    // 0xefb444: r4 = const [0x1, 0x2, 0x2, 0x2, null]
    //     0xefb444: ldr             x4, [PP, #0x40]  ; [pp+0x40] List(5) [0x1, 0x2, 0x2, 0x2, Null]
    // 0xefb448: r0 = map()
    //     0xefb448: bl              #0xc2fcc0  ; [dart:collection] ListBase::map
    // 0xefb44c: mov             x1, x0
    // 0xefb450: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefb450: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefb454: r0 = toList()
    //     0xefb454: bl              #0x8fd2f4  ; [dart:_internal] ListIterable::toList
    // 0xefb458: mov             x5, x0
    // 0xefb45c: ldur            x4, [fp, #-0x48]
    // 0xefb460: stur            x5, [fp, #-0x50]
    // 0xefb464: LoadField: r1 = r4->field_7
    //     0xefb464: ldur            w1, [x4, #7]
    // 0xefb468: DecompressPointer r1
    //     0xefb468: add             x1, x1, HEAP, lsl #32
    // 0xefb46c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb470: cmp             w1, w16
    // 0xefb474: b.eq            #0xefb508
    // 0xefb478: ldur            x6, [fp, #-0x58]
    // 0xefb47c: LoadField: r3 = r6->field_f
    //     0xefb47c: ldur            w3, [x6, #0xf]
    // 0xefb480: DecompressPointer r3
    //     0xefb480: add             x3, x3, HEAP, lsl #32
    // 0xefb484: r0 = LoadClassIdInstr(r1)
    //     0xefb484: ldur            x0, [x1, #-1]
    //     0xefb488: ubfx            x0, x0, #0xc, #0x14
    // 0xefb48c: mov             x2, x5
    // 0xefb490: r0 = GDT[cid_x0 + -0xef5]()
    //     0xefb490: sub             lr, x0, #0xef5
    //     0xefb494: ldr             lr, [x21, lr, lsl #3]
    //     0xefb498: blr             lr
    // 0xefb49c: b               #0xefb4f0
    // 0xefb4a0: sub             SP, fp, #0x78
    // 0xefb4a4: ldur            x2, [fp, #-0x60]
    // 0xefb4a8: stur            x0, [fp, #-0x50]
    // 0xefb4ac: LoadField: r3 = r2->field_1f
    //     0xefb4ac: ldur            w3, [x2, #0x1f]
    // 0xefb4b0: DecompressPointer r3
    //     0xefb4b0: add             x3, x3, HEAP, lsl #32
    // 0xefb4b4: stur            x3, [fp, #-0x48]
    // 0xefb4b8: r1 = Null
    //     0xefb4b8: mov             x1, NULL
    // 0xefb4bc: r2 = 4
    //     0xefb4bc: movz            x2, #0x4
    // 0xefb4c0: r0 = AllocateArray()
    //     0xefb4c0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb4c4: r16 = "[commander] 处理按键数据时发生错误: "
    //     0xefb4c4: add             x16, PP, #0x13, lsl #12  ; [pp+0x133a8] "[commander] 处理按键数据时发生错误: "
    //     0xefb4c8: ldr             x16, [x16, #0x3a8]
    // 0xefb4cc: StoreField: r0->field_f = r16
    //     0xefb4cc: stur            w16, [x0, #0xf]
    // 0xefb4d0: ldur            x1, [fp, #-0x50]
    // 0xefb4d4: StoreField: r0->field_13 = r1
    //     0xefb4d4: stur            w1, [x0, #0x13]
    // 0xefb4d8: str             x0, [SP]
    // 0xefb4dc: r0 = _interpolate()
    //     0xefb4dc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb4e0: ldur            x1, [fp, #-0x48]
    // 0xefb4e4: mov             x2, x0
    // 0xefb4e8: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefb4e8: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefb4ec: r0 = e()
    //     0xefb4ec: bl              #0x6ea048  ; [package:logger/src/logger.dart] Logger::e
    // 0xefb4f0: r0 = Null
    //     0xefb4f0: mov             x0, NULL
    // 0xefb4f4: LeaveFrame
    //     0xefb4f4: mov             SP, fp
    //     0xefb4f8: ldp             fp, lr, [SP], #0x10
    // 0xefb4fc: ret
    //     0xefb4fc: ret             
    // 0xefb500: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb500: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb504: b               #0xefb398
    // 0xefb508: r9 = receiveHandler
    //     0xefb508: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb50c: ldr             x9, [x9, #0x4a8]
    // 0xefb510: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb510: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleEQData(/* No info */) {
    // ** addr: 0xefb7cc, size: 0xf8
    // 0xefb7cc: EnterFrame
    //     0xefb7cc: stp             fp, lr, [SP, #-0x10]!
    //     0xefb7d0: mov             fp, SP
    // 0xefb7d4: AllocStack(0x20)
    //     0xefb7d4: sub             SP, SP, #0x20
    // 0xefb7d8: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1, fp-0x10 */)
    //     0xefb7d8: mov             x0, x1
    //     0xefb7dc: stur            x1, [fp, #-8]
    //     0xefb7e0: mov             x1, x2
    //     0xefb7e4: stur            x2, [fp, #-0x10]
    // 0xefb7e8: CheckStackOverflow
    //     0xefb7e8: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb7ec: cmp             SP, x16
    //     0xefb7f0: b.ls            #0xefb8b0
    // 0xefb7f4: r0 = LoadStaticField(0x804)
    //     0xefb7f4: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb7f8: ldr             x0, [x0, #0x1008]
    // 0xefb7fc: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb800: cmp             w0, w16
    // 0xefb804: b.ne            #0xefb810
    // 0xefb808: r2 = rsbt
    //     0xefb808: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb80c: r0 = InitLateFinalStaticField()
    //     0xefb80c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb810: LoadField: r3 = r0->field_1f
    //     0xefb810: ldur            w3, [x0, #0x1f]
    // 0xefb814: DecompressPointer r3
    //     0xefb814: add             x3, x3, HEAP, lsl #32
    // 0xefb818: stur            x3, [fp, #-0x18]
    // 0xefb81c: r1 = Null
    //     0xefb81c: mov             x1, NULL
    // 0xefb820: r2 = 4
    //     0xefb820: movz            x2, #0x4
    // 0xefb824: r0 = AllocateArray()
    //     0xefb824: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb828: r16 = "[commander] eq数据获取到了 "
    //     0xefb828: add             x16, PP, #0x13, lsl #12  ; [pp+0x136c8] "[commander] eq数据获取到了 "
    //     0xefb82c: ldr             x16, [x16, #0x6c8]
    // 0xefb830: StoreField: r0->field_f = r16
    //     0xefb830: stur            w16, [x0, #0xf]
    // 0xefb834: ldur            x1, [fp, #-0x10]
    // 0xefb838: StoreField: r0->field_13 = r1
    //     0xefb838: stur            w1, [x0, #0x13]
    // 0xefb83c: str             x0, [SP]
    // 0xefb840: r0 = _interpolate()
    //     0xefb840: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb844: ldur            x1, [fp, #-0x18]
    // 0xefb848: mov             x2, x0
    // 0xefb84c: r0 = i()
    //     0xefb84c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb850: ldur            x0, [fp, #-8]
    // 0xefb854: LoadField: r2 = r0->field_7
    //     0xefb854: ldur            w2, [x0, #7]
    // 0xefb858: DecompressPointer r2
    //     0xefb858: add             x2, x2, HEAP, lsl #32
    // 0xefb85c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb860: cmp             w2, w16
    // 0xefb864: b.eq            #0xefb8b8
    // 0xefb868: ldur            x1, [fp, #-0x10]
    // 0xefb86c: stur            x2, [fp, #-0x18]
    // 0xefb870: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefb870: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefb874: r0 = parse()
    //     0xefb874: bl              #0x621868  ; [dart:core] int::parse
    // 0xefb878: ldur            x1, [fp, #-0x18]
    // 0xefb87c: r2 = LoadClassIdInstr(r1)
    //     0xefb87c: ldur            x2, [x1, #-1]
    //     0xefb880: ubfx            x2, x2, #0xc, #0x14
    // 0xefb884: mov             x16, x0
    // 0xefb888: mov             x0, x2
    // 0xefb88c: mov             x2, x16
    // 0xefb890: ldur            x3, [fp, #-0x10]
    // 0xefb894: r0 = GDT[cid_x0 + -0xf6f]()
    //     0xefb894: sub             lr, x0, #0xf6f
    //     0xefb898: ldr             lr, [x21, lr, lsl #3]
    //     0xefb89c: blr             lr
    // 0xefb8a0: r0 = Null
    //     0xefb8a0: mov             x0, NULL
    // 0xefb8a4: LeaveFrame
    //     0xefb8a4: mov             SP, fp
    //     0xefb8a8: ldp             fp, lr, [SP], #0x10
    // 0xefb8ac: ret
    //     0xefb8ac: ret             
    // 0xefb8b0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb8b0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb8b4: b               #0xefb7f4
    // 0xefb8b8: r9 = receiveHandler
    //     0xefb8b8: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb8bc: ldr             x9, [x9, #0x4a8]
    // 0xefb8c0: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb8c0: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleFirmwareVersion(/* No info */) {
    // ** addr: 0xefb8c4, size: 0x130
    // 0xefb8c4: EnterFrame
    //     0xefb8c4: stp             fp, lr, [SP, #-0x10]!
    //     0xefb8c8: mov             fp, SP
    // 0xefb8cc: AllocStack(0x20)
    //     0xefb8cc: sub             SP, SP, #0x20
    // 0xefb8d0: SetupParameters(F8Receiver this /* r1 => r0, fp-0x8 */, dynamic _ /* r2 => r1 */)
    //     0xefb8d0: mov             x0, x1
    //     0xefb8d4: stur            x1, [fp, #-8]
    //     0xefb8d8: mov             x1, x2
    // 0xefb8dc: CheckStackOverflow
    //     0xefb8dc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb8e0: cmp             SP, x16
    //     0xefb8e4: b.ls            #0xefb9e0
    // 0xefb8e8: r16 = 32
    //     0xefb8e8: movz            x16, #0x20
    // 0xefb8ec: str             x16, [SP]
    // 0xefb8f0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefb8f0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefb8f4: ldr             x4, [x4, #0x128]
    // 0xefb8f8: r0 = parse()
    //     0xefb8f8: bl              #0x621868  ; [dart:core] int::parse
    // 0xefb8fc: mov             x2, x0
    // 0xefb900: r0 = BoxInt64Instr(r2)
    //     0xefb900: sbfiz           x0, x2, #1, #0x1f
    //     0xefb904: cmp             x2, x0, asr #1
    //     0xefb908: b.eq            #0xefb914
    //     0xefb90c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefb910: stur            x2, [x0, #7]
    // 0xefb914: r1 = 60
    //     0xefb914: movz            x1, #0x3c
    // 0xefb918: branchIfSmi(r0, 0xefb924)
    //     0xefb918: tbz             w0, #0, #0xefb924
    // 0xefb91c: r1 = LoadClassIdInstr(r0)
    //     0xefb91c: ldur            x1, [x0, #-1]
    //     0xefb920: ubfx            x1, x1, #0xc, #0x14
    // 0xefb924: str             x0, [SP]
    // 0xefb928: mov             x0, x1
    // 0xefb92c: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0xefb92c: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0xefb930: r0 = GDT[cid_x0 + 0x28cf]()
    //     0xefb930: movz            x17, #0x28cf
    //     0xefb934: add             lr, x0, x17
    //     0xefb938: ldr             lr, [x21, lr, lsl #3]
    //     0xefb93c: blr             lr
    // 0xefb940: stur            x0, [fp, #-0x10]
    // 0xefb944: r0 = LoadStaticField(0x804)
    //     0xefb944: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb948: ldr             x0, [x0, #0x1008]
    // 0xefb94c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb950: cmp             w0, w16
    // 0xefb954: b.ne            #0xefb960
    // 0xefb958: r2 = rsbt
    //     0xefb958: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb95c: r0 = InitLateFinalStaticField()
    //     0xefb95c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb960: LoadField: r3 = r0->field_1f
    //     0xefb960: ldur            w3, [x0, #0x1f]
    // 0xefb964: DecompressPointer r3
    //     0xefb964: add             x3, x3, HEAP, lsl #32
    // 0xefb968: stur            x3, [fp, #-0x18]
    // 0xefb96c: r1 = Null
    //     0xefb96c: mov             x1, NULL
    // 0xefb970: r2 = 4
    //     0xefb970: movz            x2, #0x4
    // 0xefb974: r0 = AllocateArray()
    //     0xefb974: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb978: r16 = "[commander] 固件版本数据 "
    //     0xefb978: add             x16, PP, #0x13, lsl #12  ; [pp+0x13370] "[commander] 固件版本数据 "
    //     0xefb97c: ldr             x16, [x16, #0x370]
    // 0xefb980: StoreField: r0->field_f = r16
    //     0xefb980: stur            w16, [x0, #0xf]
    // 0xefb984: ldur            x2, [fp, #-0x10]
    // 0xefb988: StoreField: r0->field_13 = r2
    //     0xefb988: stur            w2, [x0, #0x13]
    // 0xefb98c: str             x0, [SP]
    // 0xefb990: r0 = _interpolate()
    //     0xefb990: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb994: ldur            x1, [fp, #-0x18]
    // 0xefb998: mov             x2, x0
    // 0xefb99c: r0 = i()
    //     0xefb99c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb9a0: ldur            x0, [fp, #-8]
    // 0xefb9a4: LoadField: r1 = r0->field_7
    //     0xefb9a4: ldur            w1, [x0, #7]
    // 0xefb9a8: DecompressPointer r1
    //     0xefb9a8: add             x1, x1, HEAP, lsl #32
    // 0xefb9ac: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb9b0: cmp             w1, w16
    // 0xefb9b4: b.eq            #0xefb9e8
    // 0xefb9b8: r0 = LoadClassIdInstr(r1)
    //     0xefb9b8: ldur            x0, [x1, #-1]
    //     0xefb9bc: ubfx            x0, x0, #0xc, #0x14
    // 0xefb9c0: ldur            x2, [fp, #-0x10]
    // 0xefb9c4: r0 = GDT[cid_x0 + -0xb98]()
    //     0xefb9c4: sub             lr, x0, #0xb98
    //     0xefb9c8: ldr             lr, [x21, lr, lsl #3]
    //     0xefb9cc: blr             lr
    // 0xefb9d0: r0 = Null
    //     0xefb9d0: mov             x0, NULL
    // 0xefb9d4: LeaveFrame
    //     0xefb9d4: mov             SP, fp
    //     0xefb9d8: ldp             fp, lr, [SP], #0x10
    // 0xefb9dc: ret
    //     0xefb9dc: ret             
    // 0xefb9e0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb9e0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb9e4: b               #0xefb8e8
    // 0xefb9e8: r9 = receiveHandler
    //     0xefb9e8: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb9ec: ldr             x9, [x9, #0x4a8]
    // 0xefb9f0: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb9f0: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleBatteryData(/* No info */) {
    // ** addr: 0xefb9f4, size: 0x418
    // 0xefb9f4: EnterFrame
    //     0xefb9f4: stp             fp, lr, [SP, #-0x10]!
    //     0xefb9f8: mov             fp, SP
    // 0xefb9fc: AllocStack(0x78)
    //     0xefb9fc: sub             SP, SP, #0x78
    // 0xefba00: SetupParameters(F8Receiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xefba00: mov             x3, x1
    //     0xefba04: mov             x0, x2
    //     0xefba08: stur            x1, [fp, #-8]
    //     0xefba0c: stur            x2, [fp, #-0x10]
    // 0xefba10: CheckStackOverflow
    //     0xefba10: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefba14: cmp             SP, x16
    //     0xefba18: b.ls            #0xefbdf8
    // 0xefba1c: r16 = 32
    //     0xefba1c: movz            x16, #0x20
    // 0xefba20: str             x16, [SP]
    // 0xefba24: mov             x1, x0
    // 0xefba28: r2 = 14
    //     0xefba28: movz            x2, #0xe
    // 0xefba2c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefba2c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefba30: r0 = substring()
    //     0xefba30: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefba34: stur            x0, [fp, #-0x18]
    // 0xefba38: r16 = 36
    //     0xefba38: movz            x16, #0x24
    // 0xefba3c: str             x16, [SP]
    // 0xefba40: ldur            x1, [fp, #-0x10]
    // 0xefba44: r2 = 16
    //     0xefba44: movz            x2, #0x10
    // 0xefba48: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefba48: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefba4c: r0 = substring()
    //     0xefba4c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefba50: stur            x0, [fp, #-0x20]
    // 0xefba54: r16 = 40
    //     0xefba54: movz            x16, #0x28
    // 0xefba58: str             x16, [SP]
    // 0xefba5c: ldur            x1, [fp, #-0x10]
    // 0xefba60: r2 = 18
    //     0xefba60: movz            x2, #0x12
    // 0xefba64: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefba64: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefba68: r0 = substring()
    //     0xefba68: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefba6c: stur            x0, [fp, #-0x28]
    // 0xefba70: r0 = LoadStaticField(0x804)
    //     0xefba70: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefba74: ldr             x0, [x0, #0x1008]
    // 0xefba78: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefba7c: cmp             w0, w16
    // 0xefba80: b.ne            #0xefba8c
    // 0xefba84: r2 = rsbt
    //     0xefba84: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefba88: r0 = InitLateFinalStaticField()
    //     0xefba88: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefba8c: stur            x0, [fp, #-0x38]
    // 0xefba90: LoadField: r3 = r0->field_1f
    //     0xefba90: ldur            w3, [x0, #0x1f]
    // 0xefba94: DecompressPointer r3
    //     0xefba94: add             x3, x3, HEAP, lsl #32
    // 0xefba98: stur            x3, [fp, #-0x30]
    // 0xefba9c: r1 = Null
    //     0xefba9c: mov             x1, NULL
    // 0xefbaa0: r2 = 12
    //     0xefbaa0: movz            x2, #0xc
    // 0xefbaa4: r0 = AllocateArray()
    //     0xefbaa4: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefbaa8: r16 = "[commander] 电量数据: "
    //     0xefbaa8: add             x16, PP, #0x13, lsl #12  ; [pp+0x133b0] "[commander] 电量数据: "
    //     0xefbaac: ldr             x16, [x16, #0x3b0]
    // 0xefbab0: StoreField: r0->field_f = r16
    //     0xefbab0: stur            w16, [x0, #0xf]
    // 0xefbab4: ldur            x1, [fp, #-0x18]
    // 0xefbab8: StoreField: r0->field_13 = r1
    //     0xefbab8: stur            w1, [x0, #0x13]
    // 0xefbabc: r16 = " "
    //     0xefbabc: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbac0: ArrayStore: r0[0] = r16  ; List_4
    //     0xefbac0: stur            w16, [x0, #0x17]
    // 0xefbac4: ldur            x2, [fp, #-0x20]
    // 0xefbac8: StoreField: r0->field_1b = r2
    //     0xefbac8: stur            w2, [x0, #0x1b]
    // 0xefbacc: r16 = " "
    //     0xefbacc: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbad0: StoreField: r0->field_1f = r16
    //     0xefbad0: stur            w16, [x0, #0x1f]
    // 0xefbad4: ldur            x3, [fp, #-0x28]
    // 0xefbad8: StoreField: r0->field_23 = r3
    //     0xefbad8: stur            w3, [x0, #0x23]
    // 0xefbadc: str             x0, [SP]
    // 0xefbae0: r0 = _interpolate()
    //     0xefbae0: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefbae4: ldur            x1, [fp, #-0x30]
    // 0xefbae8: mov             x2, x0
    // 0xefbaec: r0 = i()
    //     0xefbaec: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefbaf0: r16 = 32
    //     0xefbaf0: movz            x16, #0x20
    // 0xefbaf4: str             x16, [SP]
    // 0xefbaf8: ldur            x1, [fp, #-0x18]
    // 0xefbafc: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefbafc: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefbb00: ldr             x4, [x4, #0x128]
    // 0xefbb04: r0 = parse()
    //     0xefbb04: bl              #0x621868  ; [dart:core] int::parse
    // 0xefbb08: mov             x2, x0
    // 0xefbb0c: r0 = BoxInt64Instr(r2)
    //     0xefbb0c: sbfiz           x0, x2, #1, #0x1f
    //     0xefbb10: cmp             x2, x0, asr #1
    //     0xefbb14: b.eq            #0xefbb20
    //     0xefbb18: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefbb1c: stur            x2, [x0, #7]
    // 0xefbb20: mov             x1, x0
    // 0xefbb24: r2 = 2
    //     0xefbb24: movz            x2, #0x2
    // 0xefbb28: r0 = _toPow2String()
    //     0xefbb28: bl              #0x6511a4  ; [dart:core] _IntegerImplementation::_toPow2String
    // 0xefbb2c: mov             x1, x0
    // 0xefbb30: ldur            x0, [fp, #-0x18]
    // 0xefbb34: LoadField: r2 = r0->field_7
    //     0xefbb34: ldur            w2, [x0, #7]
    // 0xefbb38: r3 = LoadInt32Instr(r2)
    //     0xefbb38: sbfx            x3, x2, #1, #0x1f
    // 0xefbb3c: lsl             x2, x3, #2
    // 0xefbb40: r3 = "0"
    //     0xefbb40: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefbb44: r0 = padLeft()
    //     0xefbb44: bl              #0xf1b814  ; [dart:core] _OneByteString::padLeft
    // 0xefbb48: stur            x0, [fp, #-0x30]
    // 0xefbb4c: r16 = 32
    //     0xefbb4c: movz            x16, #0x20
    // 0xefbb50: str             x16, [SP]
    // 0xefbb54: ldur            x1, [fp, #-0x20]
    // 0xefbb58: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefbb58: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefbb5c: ldr             x4, [x4, #0x128]
    // 0xefbb60: r0 = parse()
    //     0xefbb60: bl              #0x621868  ; [dart:core] int::parse
    // 0xefbb64: mov             x2, x0
    // 0xefbb68: r0 = BoxInt64Instr(r2)
    //     0xefbb68: sbfiz           x0, x2, #1, #0x1f
    //     0xefbb6c: cmp             x2, x0, asr #1
    //     0xefbb70: b.eq            #0xefbb7c
    //     0xefbb74: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefbb78: stur            x2, [x0, #7]
    // 0xefbb7c: mov             x1, x0
    // 0xefbb80: r2 = 2
    //     0xefbb80: movz            x2, #0x2
    // 0xefbb84: r0 = _toPow2String()
    //     0xefbb84: bl              #0x6511a4  ; [dart:core] _IntegerImplementation::_toPow2String
    // 0xefbb88: mov             x1, x0
    // 0xefbb8c: ldur            x0, [fp, #-0x20]
    // 0xefbb90: LoadField: r2 = r0->field_7
    //     0xefbb90: ldur            w2, [x0, #7]
    // 0xefbb94: r3 = LoadInt32Instr(r2)
    //     0xefbb94: sbfx            x3, x2, #1, #0x1f
    // 0xefbb98: lsl             x2, x3, #2
    // 0xefbb9c: r3 = "0"
    //     0xefbb9c: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefbba0: r0 = padLeft()
    //     0xefbba0: bl              #0xf1b814  ; [dart:core] _OneByteString::padLeft
    // 0xefbba4: ldur            x1, [fp, #-0x30]
    // 0xefbba8: r2 = 1
    //     0xefbba8: movz            x2, #0x1
    // 0xefbbac: stur            x0, [fp, #-0x40]
    // 0xefbbb0: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefbbb0: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefbbb4: r0 = substring()
    //     0xefbbb4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbbb8: r16 = 4
    //     0xefbbb8: movz            x16, #0x4
    // 0xefbbbc: str             x16, [SP]
    // 0xefbbc0: mov             x1, x0
    // 0xefbbc4: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefbbc4: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefbbc8: ldr             x4, [x4, #0x128]
    // 0xefbbcc: r0 = parse()
    //     0xefbbcc: bl              #0x621868  ; [dart:core] int::parse
    // 0xefbbd0: ldur            x1, [fp, #-0x40]
    // 0xefbbd4: r2 = 1
    //     0xefbbd4: movz            x2, #0x1
    // 0xefbbd8: stur            x0, [fp, #-0x48]
    // 0xefbbdc: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefbbdc: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefbbe0: r0 = substring()
    //     0xefbbe0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbbe4: r16 = 4
    //     0xefbbe4: movz            x16, #0x4
    // 0xefbbe8: str             x16, [SP]
    // 0xefbbec: mov             x1, x0
    // 0xefbbf0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefbbf0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefbbf4: ldr             x4, [x4, #0x128]
    // 0xefbbf8: r0 = parse()
    //     0xefbbf8: bl              #0x621868  ; [dart:core] int::parse
    // 0xefbbfc: stur            x0, [fp, #-0x50]
    // 0xefbc00: r16 = 32
    //     0xefbc00: movz            x16, #0x20
    // 0xefbc04: str             x16, [SP]
    // 0xefbc08: ldur            x1, [fp, #-0x28]
    // 0xefbc0c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefbc0c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefbc10: ldr             x4, [x4, #0x128]
    // 0xefbc14: r0 = parse()
    //     0xefbc14: bl              #0x621868  ; [dart:core] int::parse
    // 0xefbc18: stur            x0, [fp, #-0x58]
    // 0xefbc1c: r16 = 2
    //     0xefbc1c: movz            x16, #0x2
    // 0xefbc20: str             x16, [SP]
    // 0xefbc24: ldur            x1, [fp, #-0x30]
    // 0xefbc28: r2 = 0
    //     0xefbc28: movz            x2, #0
    // 0xefbc2c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefbc2c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefbc30: r0 = substring()
    //     0xefbc30: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbc34: r1 = LoadClassIdInstr(r0)
    //     0xefbc34: ldur            x1, [x0, #-1]
    //     0xefbc38: ubfx            x1, x1, #0xc, #0x14
    // 0xefbc3c: r16 = "1"
    //     0xefbc3c: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefbc40: ldr             x16, [x16, #0x248]
    // 0xefbc44: stp             x16, x0, [SP]
    // 0xefbc48: mov             x0, x1
    // 0xefbc4c: mov             lr, x0
    // 0xefbc50: ldr             lr, [x21, lr, lsl #3]
    // 0xefbc54: blr             lr
    // 0xefbc58: stur            x0, [fp, #-0x60]
    // 0xefbc5c: r16 = 2
    //     0xefbc5c: movz            x16, #0x2
    // 0xefbc60: str             x16, [SP]
    // 0xefbc64: ldur            x1, [fp, #-0x40]
    // 0xefbc68: r2 = 0
    //     0xefbc68: movz            x2, #0
    // 0xefbc6c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefbc6c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefbc70: r0 = substring()
    //     0xefbc70: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbc74: r1 = LoadClassIdInstr(r0)
    //     0xefbc74: ldur            x1, [x0, #-1]
    //     0xefbc78: ubfx            x1, x1, #0xc, #0x14
    // 0xefbc7c: r16 = "1"
    //     0xefbc7c: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefbc80: ldr             x16, [x16, #0x248]
    // 0xefbc84: stp             x16, x0, [SP]
    // 0xefbc88: mov             x0, x1
    // 0xefbc8c: mov             lr, x0
    // 0xefbc90: ldr             lr, [x21, lr, lsl #3]
    // 0xefbc94: blr             lr
    // 0xefbc98: stur            x0, [fp, #-0x68]
    // 0xefbc9c: r0 = RBatteryData()
    //     0xefbc9c: bl              #0xefbe0c  ; AllocateRBatteryDataStub -> RBatteryData (size=0x2c)
    // 0xefbca0: mov             x1, x0
    // 0xefbca4: ldur            x0, [fp, #-0x48]
    // 0xefbca8: StoreField: r1->field_7 = r0
    //     0xefbca8: stur            x0, [x1, #7]
    // 0xefbcac: ldur            x0, [fp, #-0x50]
    // 0xefbcb0: StoreField: r1->field_f = r0
    //     0xefbcb0: stur            x0, [x1, #0xf]
    // 0xefbcb4: ldur            x0, [fp, #-0x58]
    // 0xefbcb8: ArrayStore: r1[0] = r0  ; List_8
    //     0xefbcb8: stur            x0, [x1, #0x17]
    // 0xefbcbc: ldur            x4, [fp, #-0x60]
    // 0xefbcc0: StoreField: r1->field_1f = r4
    //     0xefbcc0: stur            w4, [x1, #0x1f]
    // 0xefbcc4: ldur            x5, [fp, #-0x68]
    // 0xefbcc8: StoreField: r1->field_23 = r5
    //     0xefbcc8: stur            w5, [x1, #0x23]
    // 0xefbccc: r0 = false
    //     0xefbccc: add             x0, NULL, #0x30  ; false
    // 0xefbcd0: StoreField: r1->field_27 = r0
    //     0xefbcd0: stur            w0, [x1, #0x27]
    // 0xefbcd4: ldur            x0, [fp, #-8]
    // 0xefbcd8: LoadField: r2 = r0->field_7
    //     0xefbcd8: ldur            w2, [x0, #7]
    // 0xefbcdc: DecompressPointer r2
    //     0xefbcdc: add             x2, x2, HEAP, lsl #32
    // 0xefbce0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefbce4: cmp             w2, w16
    // 0xefbce8: b.eq            #0xefbe00
    // 0xefbcec: r0 = LoadClassIdInstr(r2)
    //     0xefbcec: ldur            x0, [x2, #-1]
    //     0xefbcf0: ubfx            x0, x0, #0xc, #0x14
    // 0xefbcf4: mov             x16, x1
    // 0xefbcf8: mov             x1, x2
    // 0xefbcfc: mov             x2, x16
    // 0xefbd00: ldur            x3, [fp, #-0x10]
    // 0xefbd04: r0 = GDT[cid_x0 + -0xf7d]()
    //     0xefbd04: sub             lr, x0, #0xf7d
    //     0xefbd08: ldr             lr, [x21, lr, lsl #3]
    //     0xefbd0c: blr             lr
    // 0xefbd10: ldur            x0, [fp, #-0x38]
    // 0xefbd14: LoadField: r3 = r0->field_1f
    //     0xefbd14: ldur            w3, [x0, #0x1f]
    // 0xefbd18: DecompressPointer r3
    //     0xefbd18: add             x3, x3, HEAP, lsl #32
    // 0xefbd1c: stur            x3, [fp, #-8]
    // 0xefbd20: r1 = Null
    //     0xefbd20: mov             x1, NULL
    // 0xefbd24: r2 = 40
    //     0xefbd24: movz            x2, #0x28
    // 0xefbd28: r0 = AllocateArray()
    //     0xefbd28: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefbd2c: r16 = "[commander] 电量数据 原始数据 "
    //     0xefbd2c: add             x16, PP, #0x13, lsl #12  ; [pp+0x133b8] "[commander] 电量数据 原始数据 "
    //     0xefbd30: ldr             x16, [x16, #0x3b8]
    // 0xefbd34: StoreField: r0->field_f = r16
    //     0xefbd34: stur            w16, [x0, #0xf]
    // 0xefbd38: ldur            x1, [fp, #-0x18]
    // 0xefbd3c: StoreField: r0->field_13 = r1
    //     0xefbd3c: stur            w1, [x0, #0x13]
    // 0xefbd40: r16 = " "
    //     0xefbd40: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbd44: ArrayStore: r0[0] = r16  ; List_4
    //     0xefbd44: stur            w16, [x0, #0x17]
    // 0xefbd48: ldur            x2, [fp, #-0x20]
    // 0xefbd4c: StoreField: r0->field_1b = r2
    //     0xefbd4c: stur            w2, [x0, #0x1b]
    // 0xefbd50: r16 = " "
    //     0xefbd50: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbd54: StoreField: r0->field_1f = r16
    //     0xefbd54: stur            w16, [x0, #0x1f]
    // 0xefbd58: ldur            x3, [fp, #-0x28]
    // 0xefbd5c: StoreField: r0->field_23 = r3
    //     0xefbd5c: stur            w3, [x0, #0x23]
    // 0xefbd60: r16 = " 十六进制原始数据："
    //     0xefbd60: add             x16, PP, #0x12, lsl #12  ; [pp+0x125a0] " 十六进制原始数据："
    //     0xefbd64: ldr             x16, [x16, #0x5a0]
    // 0xefbd68: StoreField: r0->field_27 = r16
    //     0xefbd68: stur            w16, [x0, #0x27]
    // 0xefbd6c: StoreField: r0->field_2b = r1
    //     0xefbd6c: stur            w1, [x0, #0x2b]
    // 0xefbd70: r16 = " "
    //     0xefbd70: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbd74: StoreField: r0->field_2f = r16
    //     0xefbd74: stur            w16, [x0, #0x2f]
    // 0xefbd78: StoreField: r0->field_33 = r2
    //     0xefbd78: stur            w2, [x0, #0x33]
    // 0xefbd7c: r16 = " "
    //     0xefbd7c: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbd80: StoreField: r0->field_37 = r16
    //     0xefbd80: stur            w16, [x0, #0x37]
    // 0xefbd84: StoreField: r0->field_3b = r3
    //     0xefbd84: stur            w3, [x0, #0x3b]
    // 0xefbd88: r16 = " 左耳二进制下数据"
    //     0xefbd88: add             x16, PP, #0x13, lsl #12  ; [pp+0x133c0] " 左耳二进制下数据"
    //     0xefbd8c: ldr             x16, [x16, #0x3c0]
    // 0xefbd90: StoreField: r0->field_3f = r16
    //     0xefbd90: stur            w16, [x0, #0x3f]
    // 0xefbd94: ldur            x1, [fp, #-0x30]
    // 0xefbd98: StoreField: r0->field_43 = r1
    //     0xefbd98: stur            w1, [x0, #0x43]
    // 0xefbd9c: r16 = " 右耳二进制数据"
    //     0xefbd9c: add             x16, PP, #0x13, lsl #12  ; [pp+0x133c8] " 右耳二进制数据"
    //     0xefbda0: ldr             x16, [x16, #0x3c8]
    // 0xefbda4: StoreField: r0->field_47 = r16
    //     0xefbda4: stur            w16, [x0, #0x47]
    // 0xefbda8: ldur            x1, [fp, #-0x40]
    // 0xefbdac: StoreField: r0->field_4b = r1
    //     0xefbdac: stur            w1, [x0, #0x4b]
    // 0xefbdb0: r16 = " 人仓L/R "
    //     0xefbdb0: add             x16, PP, #0x13, lsl #12  ; [pp+0x133d0] " 人仓L/R "
    //     0xefbdb4: ldr             x16, [x16, #0x3d0]
    // 0xefbdb8: StoreField: r0->field_4f = r16
    //     0xefbdb8: stur            w16, [x0, #0x4f]
    // 0xefbdbc: ldur            x1, [fp, #-0x60]
    // 0xefbdc0: StoreField: r0->field_53 = r1
    //     0xefbdc0: stur            w1, [x0, #0x53]
    // 0xefbdc4: r16 = " "
    //     0xefbdc4: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefbdc8: StoreField: r0->field_57 = r16
    //     0xefbdc8: stur            w16, [x0, #0x57]
    // 0xefbdcc: ldur            x1, [fp, #-0x68]
    // 0xefbdd0: StoreField: r0->field_5b = r1
    //     0xefbdd0: stur            w1, [x0, #0x5b]
    // 0xefbdd4: str             x0, [SP]
    // 0xefbdd8: r0 = _interpolate()
    //     0xefbdd8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefbddc: ldur            x1, [fp, #-8]
    // 0xefbde0: mov             x2, x0
    // 0xefbde4: r0 = t()
    //     0xefbde4: bl              #0x798af0  ; [package:logger/src/logger.dart] Logger::t
    // 0xefbde8: r0 = Null
    //     0xefbde8: mov             x0, NULL
    // 0xefbdec: LeaveFrame
    //     0xefbdec: mov             SP, fp
    //     0xefbdf0: ldp             fp, lr, [SP], #0x10
    // 0xefbdf4: ret
    //     0xefbdf4: ret             
    // 0xefbdf8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefbdf8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefbdfc: b               #0xefba1c
    // 0xefbe00: r9 = receiveHandler
    //     0xefbe00: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefbe04: ldr             x9, [x9, #0x4a8]
    // 0xefbe08: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefbe08: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
}
