// lib: , url: package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart

// class id: 1050401, size: 0x8
class :: {
}

// class id: 446, size: 0x14, field offset: 0xc
class RsCommonReceiver extends RReceiver {

  _ checkModule(/* No info */) {
    // ** addr: 0xedb8d0, size: 0x5c
    // 0xedb8d0: EnterFrame
    //     0xedb8d0: stp             fp, lr, [SP, #-0x10]!
    //     0xedb8d4: mov             fp, SP
    // 0xedb8d8: CheckStackOverflow
    //     0xedb8d8: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xedb8dc: cmp             SP, x16
    //     0xedb8e0: b.ls            #0xedb924
    // 0xedb8e4: r0 = LoadStaticField(0x804)
    //     0xedb8e4: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xedb8e8: ldr             x0, [x0, #0x1008]
    // 0xedb8ec: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xedb8f0: cmp             w0, w16
    // 0xedb8f4: b.ne            #0xedb900
    // 0xedb8f8: r2 = rsbt
    //     0xedb8f8: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xedb8fc: r0 = InitLateFinalStaticField()
    //     0xedb8fc: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xedb900: LoadField: r1 = r0->field_1f
    //     0xedb900: ldur            w1, [x0, #0x1f]
    // 0xedb904: DecompressPointer r1
    //     0xedb904: add             x1, x1, HEAP, lsl #32
    // 0xedb908: r2 = "[commander] 模块检查 rs_common协议暂不支持模块消息检查功能"
    //     0xedb908: add             x2, PP, #0x13, lsl #12  ; [pp+0x136b0] "[commander] 模块检查 rs_common协议暂不支持模块消息检查功能"
    //     0xedb90c: ldr             x2, [x2, #0x6b0]
    // 0xedb910: r0 = i()
    //     0xedb910: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xedb914: r0 = false
    //     0xedb914: add             x0, NULL, #0x30  ; false
    // 0xedb918: LeaveFrame
    //     0xedb918: mov             SP, fp
    //     0xedb91c: ldp             fp, lr, [SP], #0x10
    // 0xedb920: ret
    //     0xedb920: ret             
    // 0xedb924: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xedb924: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xedb928: b               #0xedb8e4
  }
  [closure] int <anonymous closure>(dynamic, int) {
    // ** addr: 0xefb514, size: 0x11c
    // 0xefb514: EnterFrame
    //     0xefb514: stp             fp, lr, [SP, #-0x10]!
    //     0xefb518: mov             fp, SP
    // 0xefb51c: AllocStack(0x10)
    //     0xefb51c: sub             SP, SP, #0x10
    // 0xefb520: SetupParameters([dynamic _ /* r0 */])
    //     0xefb520: ldr             x0, [fp, #0x18]
    //     0xefb524: ldur            w1, [x0, #0x17]
    //     0xefb528: add             x1, x1, HEAP, lsl #32
    // 0xefb52c: CheckStackOverflow
    //     0xefb52c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb530: cmp             SP, x16
    //     0xefb534: b.ls            #0xefb628
    // 0xefb538: ldr             x0, [fp, #0x10]
    // 0xefb53c: r2 = LoadInt32Instr(r0)
    //     0xefb53c: sbfx            x2, x0, #1, #0x1f
    //     0xefb540: tbz             w0, #0, #0xefb548
    //     0xefb544: ldur            x2, [x0, #7]
    // 0xefb548: add             x3, x2, #1
    // 0xefb54c: LoadField: r4 = r1->field_f
    //     0xefb54c: ldur            w4, [x1, #0xf]
    // 0xefb550: DecompressPointer r4
    //     0xefb550: add             x4, x4, HEAP, lsl #32
    // 0xefb554: LoadField: r1 = r4->field_7
    //     0xefb554: ldur            w1, [x4, #7]
    // 0xefb558: r5 = LoadInt32Instr(r1)
    //     0xefb558: sbfx            x5, x1, #1, #0x1f
    // 0xefb55c: cmp             x3, x5
    // 0xefb560: b.le            #0xefb5d4
    // 0xefb564: r0 = LoadStaticField(0x804)
    //     0xefb564: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb568: ldr             x0, [x0, #0x1008]
    // 0xefb56c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb570: cmp             w0, w16
    // 0xefb574: b.ne            #0xefb580
    // 0xefb578: r2 = rsbt
    //     0xefb578: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb57c: r0 = InitLateFinalStaticField()
    //     0xefb57c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb580: LoadField: r3 = r0->field_1f
    //     0xefb580: ldur            w3, [x0, #0x1f]
    // 0xefb584: DecompressPointer r3
    //     0xefb584: add             x3, x3, HEAP, lsl #32
    // 0xefb588: stur            x3, [fp, #-8]
    // 0xefb58c: r1 = Null
    //     0xefb58c: mov             x1, NULL
    // 0xefb590: r2 = 4
    //     0xefb590: movz            x2, #0x4
    // 0xefb594: r0 = AllocateArray()
    //     0xefb594: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb598: r16 = "[commander] 按键数据长度不足，索引越界: "
    //     0xefb598: add             x16, PP, #0x13, lsl #12  ; [pp+0x136e0] "[commander] 按键数据长度不足，索引越界: "
    //     0xefb59c: ldr             x16, [x16, #0x6e0]
    // 0xefb5a0: StoreField: r0->field_f = r16
    //     0xefb5a0: stur            w16, [x0, #0xf]
    // 0xefb5a4: ldr             x1, [fp, #0x10]
    // 0xefb5a8: StoreField: r0->field_13 = r1
    //     0xefb5a8: stur            w1, [x0, #0x13]
    // 0xefb5ac: str             x0, [SP]
    // 0xefb5b0: r0 = _interpolate()
    //     0xefb5b0: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb5b4: ldur            x1, [fp, #-8]
    // 0xefb5b8: mov             x2, x0
    // 0xefb5bc: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefb5bc: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefb5c0: r0 = w()
    //     0xefb5c0: bl              #0x6bf3f0  ; [package:logger/src/logger.dart] Logger::w
    // 0xefb5c4: r0 = -2
    //     0xefb5c4: orr             x0, xzr, #0xfffffffffffffffe
    // 0xefb5c8: LeaveFrame
    //     0xefb5c8: mov             SP, fp
    //     0xefb5cc: ldp             fp, lr, [SP], #0x10
    // 0xefb5d0: ret
    //     0xefb5d0: ret             
    // 0xefb5d4: r0 = BoxInt64Instr(r3)
    //     0xefb5d4: sbfiz           x0, x3, #1, #0x1f
    //     0xefb5d8: cmp             x3, x0, asr #1
    //     0xefb5dc: b.eq            #0xefb5e8
    //     0xefb5e0: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefb5e4: stur            x3, [x0, #7]
    // 0xefb5e8: str             x0, [SP]
    // 0xefb5ec: mov             x1, x4
    // 0xefb5f0: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefb5f0: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefb5f4: r0 = substring()
    //     0xefb5f4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefb5f8: mov             x1, x0
    // 0xefb5fc: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefb5fc: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefb600: r0 = parse()
    //     0xefb600: bl              #0x621868  ; [dart:core] int::parse
    // 0xefb604: mov             x2, x0
    // 0xefb608: r0 = BoxInt64Instr(r2)
    //     0xefb608: sbfiz           x0, x2, #1, #0x1f
    //     0xefb60c: cmp             x2, x0, asr #1
    //     0xefb610: b.eq            #0xefb61c
    //     0xefb614: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefb618: stur            x2, [x0, #7]
    // 0xefb61c: LeaveFrame
    //     0xefb61c: mov             SP, fp
    //     0xefb620: ldp             fp, lr, [SP], #0x10
    // 0xefb624: ret
    //     0xefb624: ret             
    // 0xefb628: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb628: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb62c: b               #0xefb538
  }
  _ _handleKeyData(/* No info */) {
    // ** addr: 0xefb630, size: 0x19c
    // 0xefb630: EnterFrame
    //     0xefb630: stp             fp, lr, [SP, #-0x10]!
    //     0xefb634: mov             fp, SP
    // 0xefb638: AllocStack(0x78)
    //     0xefb638: sub             SP, SP, #0x78
    // 0xefb63c: SetupParameters(RsCommonReceiver this /* r1 => r1, fp-0x48 */, dynamic _ /* r2 => r2, fp-0x50 */)
    //     0xefb63c: stur            x1, [fp, #-0x48]
    //     0xefb640: stur            x2, [fp, #-0x50]
    // 0xefb644: CheckStackOverflow
    //     0xefb644: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefb648: cmp             SP, x16
    //     0xefb64c: b.ls            #0xefb7b8
    // 0xefb650: r1 = 1
    //     0xefb650: movz            x1, #0x1
    // 0xefb654: r0 = AllocateContext()
    //     0xefb654: bl              #0xf1dacc  ; AllocateContextStub
    // 0xefb658: mov             x1, x0
    // 0xefb65c: ldur            x0, [fp, #-0x50]
    // 0xefb660: stur            x1, [fp, #-0x58]
    // 0xefb664: StoreField: r1->field_f = r0
    //     0xefb664: stur            w0, [x1, #0xf]
    // 0xefb668: r0 = LoadStaticField(0x804)
    //     0xefb668: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefb66c: ldr             x0, [x0, #0x1008]
    // 0xefb670: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb674: cmp             w0, w16
    // 0xefb678: b.ne            #0xefb684
    // 0xefb67c: r2 = rsbt
    //     0xefb67c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefb680: r0 = InitLateFinalStaticField()
    //     0xefb680: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefb684: stur            x0, [fp, #-0x60]
    // 0xefb688: LoadField: r3 = r0->field_1f
    //     0xefb688: ldur            w3, [x0, #0x1f]
    // 0xefb68c: DecompressPointer r3
    //     0xefb68c: add             x3, x3, HEAP, lsl #32
    // 0xefb690: stur            x3, [fp, #-0x50]
    // 0xefb694: r1 = Null
    //     0xefb694: mov             x1, NULL
    // 0xefb698: r2 = 4
    //     0xefb698: movz            x2, #0x4
    // 0xefb69c: r0 = AllocateArray()
    //     0xefb69c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb6a0: r16 = "[commander] 按键数据获取到了 "
    //     0xefb6a0: add             x16, PP, #0x13, lsl #12  ; [pp+0x13398] "[commander] 按键数据获取到了 "
    //     0xefb6a4: ldr             x16, [x16, #0x398]
    // 0xefb6a8: StoreField: r0->field_f = r16
    //     0xefb6a8: stur            w16, [x0, #0xf]
    // 0xefb6ac: ldur            x2, [fp, #-0x58]
    // 0xefb6b0: LoadField: r1 = r2->field_f
    //     0xefb6b0: ldur            w1, [x2, #0xf]
    // 0xefb6b4: DecompressPointer r1
    //     0xefb6b4: add             x1, x1, HEAP, lsl #32
    // 0xefb6b8: StoreField: r0->field_13 = r1
    //     0xefb6b8: stur            w1, [x0, #0x13]
    // 0xefb6bc: str             x0, [SP]
    // 0xefb6c0: r0 = _interpolate()
    //     0xefb6c0: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb6c4: ldur            x1, [fp, #-0x50]
    // 0xefb6c8: mov             x2, x0
    // 0xefb6cc: r0 = i()
    //     0xefb6cc: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefb6d0: ldur            x3, [fp, #-0x48]
    // 0xefb6d4: ldur            x0, [fp, #-0x58]
    // 0xefb6d8: mov             x2, x0
    // 0xefb6dc: r1 = Function '<anonymous closure>':.
    //     0xefb6dc: add             x1, PP, #0x13, lsl #12  ; [pp+0x136d0] AnonymousClosure: (0xefb514), in [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleKeyData (0xefb630)
    //     0xefb6e0: ldr             x1, [x1, #0x6d0]
    // 0xefb6e4: r0 = AllocateClosure()
    //     0xefb6e4: bl              #0xf1dea0  ; AllocateClosureStub
    // 0xefb6e8: r16 = <int>
    //     0xefb6e8: ldr             x16, [PP, #0x988]  ; [pp+0x988] TypeArguments: <int>
    // 0xefb6ec: r30 = const [0xb, 0xf, 0x13, 0x1f, 0x23, 0x27]
    //     0xefb6ec: add             lr, PP, #0x13, lsl #12  ; [pp+0x136d8] List<int>(6)
    //     0xefb6f0: ldr             lr, [lr, #0x6d8]
    // 0xefb6f4: stp             lr, x16, [SP, #8]
    // 0xefb6f8: str             x0, [SP]
    // 0xefb6fc: r4 = const [0x1, 0x2, 0x2, 0x2, null]
    //     0xefb6fc: ldr             x4, [PP, #0x40]  ; [pp+0x40] List(5) [0x1, 0x2, 0x2, 0x2, Null]
    // 0xefb700: r0 = map()
    //     0xefb700: bl              #0xc2fcc0  ; [dart:collection] ListBase::map
    // 0xefb704: mov             x1, x0
    // 0xefb708: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xefb708: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xefb70c: r0 = toList()
    //     0xefb70c: bl              #0x8fd2f4  ; [dart:_internal] ListIterable::toList
    // 0xefb710: mov             x5, x0
    // 0xefb714: ldur            x4, [fp, #-0x48]
    // 0xefb718: stur            x5, [fp, #-0x50]
    // 0xefb71c: LoadField: r1 = r4->field_7
    //     0xefb71c: ldur            w1, [x4, #7]
    // 0xefb720: DecompressPointer r1
    //     0xefb720: add             x1, x1, HEAP, lsl #32
    // 0xefb724: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefb728: cmp             w1, w16
    // 0xefb72c: b.eq            #0xefb7c0
    // 0xefb730: ldur            x6, [fp, #-0x58]
    // 0xefb734: LoadField: r3 = r6->field_f
    //     0xefb734: ldur            w3, [x6, #0xf]
    // 0xefb738: DecompressPointer r3
    //     0xefb738: add             x3, x3, HEAP, lsl #32
    // 0xefb73c: r0 = LoadClassIdInstr(r1)
    //     0xefb73c: ldur            x0, [x1, #-1]
    //     0xefb740: ubfx            x0, x0, #0xc, #0x14
    // 0xefb744: mov             x2, x5
    // 0xefb748: r0 = GDT[cid_x0 + -0xef5]()
    //     0xefb748: sub             lr, x0, #0xef5
    //     0xefb74c: ldr             lr, [x21, lr, lsl #3]
    //     0xefb750: blr             lr
    // 0xefb754: b               #0xefb7a8
    // 0xefb758: sub             SP, fp, #0x78
    // 0xefb75c: ldur            x2, [fp, #-0x60]
    // 0xefb760: stur            x0, [fp, #-0x50]
    // 0xefb764: LoadField: r3 = r2->field_1f
    //     0xefb764: ldur            w3, [x2, #0x1f]
    // 0xefb768: DecompressPointer r3
    //     0xefb768: add             x3, x3, HEAP, lsl #32
    // 0xefb76c: stur            x3, [fp, #-0x48]
    // 0xefb770: r1 = Null
    //     0xefb770: mov             x1, NULL
    // 0xefb774: r2 = 4
    //     0xefb774: movz            x2, #0x4
    // 0xefb778: r0 = AllocateArray()
    //     0xefb778: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefb77c: r16 = "[commander] 处理按键数据时发生错误: "
    //     0xefb77c: add             x16, PP, #0x13, lsl #12  ; [pp+0x133a8] "[commander] 处理按键数据时发生错误: "
    //     0xefb780: ldr             x16, [x16, #0x3a8]
    // 0xefb784: StoreField: r0->field_f = r16
    //     0xefb784: stur            w16, [x0, #0xf]
    // 0xefb788: ldur            x1, [fp, #-0x50]
    // 0xefb78c: StoreField: r0->field_13 = r1
    //     0xefb78c: stur            w1, [x0, #0x13]
    // 0xefb790: str             x0, [SP]
    // 0xefb794: r0 = _interpolate()
    //     0xefb794: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefb798: ldur            x1, [fp, #-0x48]
    // 0xefb79c: mov             x2, x0
    // 0xefb7a0: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefb7a0: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefb7a4: r0 = e()
    //     0xefb7a4: bl              #0x6ea048  ; [package:logger/src/logger.dart] Logger::e
    // 0xefb7a8: r0 = Null
    //     0xefb7a8: mov             x0, NULL
    // 0xefb7ac: LeaveFrame
    //     0xefb7ac: mov             SP, fp
    //     0xefb7b0: ldp             fp, lr, [SP], #0x10
    // 0xefb7b4: ret
    //     0xefb7b4: ret             
    // 0xefb7b8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefb7b8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefb7bc: b               #0xefb650
    // 0xefb7c0: r9 = receiveHandler
    //     0xefb7c0: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefb7c4: ldr             x9, [x9, #0x4a8]
    // 0xefb7c8: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefb7c8: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ process(/* No info */) {
    // ** addr: 0xefbea8, size: 0x3bc
    // 0xefbea8: EnterFrame
    //     0xefbea8: stp             fp, lr, [SP, #-0x10]!
    //     0xefbeac: mov             fp, SP
    // 0xefbeb0: AllocStack(0x30)
    //     0xefbeb0: sub             SP, SP, #0x30
    // 0xefbeb4: r0 = false
    //     0xefbeb4: add             x0, NULL, #0x30  ; false
    // 0xefbeb8: stur            x1, [fp, #-8]
    // 0xefbebc: mov             x16, x2
    // 0xefbec0: mov             x2, x1
    // 0xefbec4: mov             x1, x16
    // 0xefbec8: stur            x1, [fp, #-0x10]
    // 0xefbecc: CheckStackOverflow
    //     0xefbecc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefbed0: cmp             SP, x16
    //     0xefbed4: b.ls            #0xefc25c
    // 0xefbed8: StoreField: r2->field_f = r0
    //     0xefbed8: stur            w0, [x2, #0xf]
    // 0xefbedc: r0 = LoadStaticField(0x804)
    //     0xefbedc: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefbee0: ldr             x0, [x0, #0x1008]
    // 0xefbee4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefbee8: cmp             w0, w16
    // 0xefbeec: b.ne            #0xefbef8
    // 0xefbef0: r2 = rsbt
    //     0xefbef0: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefbef4: r0 = InitLateFinalStaticField()
    //     0xefbef4: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefbef8: LoadField: r3 = r0->field_1f
    //     0xefbef8: ldur            w3, [x0, #0x1f]
    // 0xefbefc: DecompressPointer r3
    //     0xefbefc: add             x3, x3, HEAP, lsl #32
    // 0xefbf00: stur            x3, [fp, #-0x18]
    // 0xefbf04: r1 = Null
    //     0xefbf04: mov             x1, NULL
    // 0xefbf08: r2 = 12
    //     0xefbf08: movz            x2, #0xc
    // 0xefbf0c: r0 = AllocateArray()
    //     0xefbf0c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefbf10: stur            x0, [fp, #-0x20]
    // 0xefbf14: r16 = "[commander][receiver][rs_common]->>>> "
    //     0xefbf14: add             x16, PP, #0x13, lsl #12  ; [pp+0x136b8] "[commander][receiver][rs_common]->>>> "
    //     0xefbf18: ldr             x16, [x16, #0x6b8]
    // 0xefbf1c: StoreField: r0->field_f = r16
    //     0xefbf1c: stur            w16, [x0, #0xf]
    // 0xefbf20: ldur            x3, [fp, #-0x10]
    // 0xefbf24: StoreField: r0->field_13 = r3
    //     0xefbf24: stur            w3, [x0, #0x13]
    // 0xefbf28: r16 = " flag位: "
    //     0xefbf28: add             x16, PP, #0x13, lsl #12  ; [pp+0x136c0] " flag位: "
    //     0xefbf2c: ldr             x16, [x16, #0x6c0]
    // 0xefbf30: ArrayStore: r0[0] = r16  ; List_4
    //     0xefbf30: stur            w16, [x0, #0x17]
    // 0xefbf34: r16 = 16
    //     0xefbf34: movz            x16, #0x10
    // 0xefbf38: str             x16, [SP]
    // 0xefbf3c: mov             x1, x3
    // 0xefbf40: r2 = 6
    //     0xefbf40: movz            x2, #0x6
    // 0xefbf44: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefbf44: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefbf48: r0 = substring()
    //     0xefbf48: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbf4c: ldur            x1, [fp, #-0x20]
    // 0xefbf50: ArrayStore: r1[3] = r0  ; List_4
    //     0xefbf50: add             x25, x1, #0x1b
    //     0xefbf54: str             w0, [x25]
    //     0xefbf58: tbz             w0, #0, #0xefbf74
    //     0xefbf5c: ldurb           w16, [x1, #-1]
    //     0xefbf60: ldurb           w17, [x0, #-1]
    //     0xefbf64: and             x16, x17, x16, lsr #2
    //     0xefbf68: tst             x16, HEAP, lsr #32
    //     0xefbf6c: b.eq            #0xefbf74
    //     0xefbf70: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xefbf74: ldur            x0, [fp, #-0x20]
    // 0xefbf78: r16 = " value为"
    //     0xefbf78: add             x16, PP, #0x12, lsl #12  ; [pp+0x12ae8] " value为"
    //     0xefbf7c: ldr             x16, [x16, #0xae8]
    // 0xefbf80: StoreField: r0->field_1f = r16
    //     0xefbf80: stur            w16, [x0, #0x1f]
    // 0xefbf84: r16 = 18
    //     0xefbf84: movz            x16, #0x12
    // 0xefbf88: str             x16, [SP]
    // 0xefbf8c: ldur            x1, [fp, #-0x10]
    // 0xefbf90: r2 = 8
    //     0xefbf90: movz            x2, #0x8
    // 0xefbf94: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefbf94: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefbf98: r0 = substring()
    //     0xefbf98: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbf9c: ldur            x1, [fp, #-0x20]
    // 0xefbfa0: ArrayStore: r1[5] = r0  ; List_4
    //     0xefbfa0: add             x25, x1, #0x23
    //     0xefbfa4: str             w0, [x25]
    //     0xefbfa8: tbz             w0, #0, #0xefbfc4
    //     0xefbfac: ldurb           w16, [x1, #-1]
    //     0xefbfb0: ldurb           w17, [x0, #-1]
    //     0xefbfb4: and             x16, x17, x16, lsr #2
    //     0xefbfb8: tst             x16, HEAP, lsr #32
    //     0xefbfbc: b.eq            #0xefbfc4
    //     0xefbfc0: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xefbfc4: ldur            x16, [fp, #-0x20]
    // 0xefbfc8: str             x16, [SP]
    // 0xefbfcc: r0 = _interpolate()
    //     0xefbfcc: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefbfd0: ldur            x1, [fp, #-0x18]
    // 0xefbfd4: mov             x2, x0
    // 0xefbfd8: r0 = i()
    //     0xefbfd8: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefbfdc: r16 = 16
    //     0xefbfdc: movz            x16, #0x10
    // 0xefbfe0: str             x16, [SP]
    // 0xefbfe4: ldur            x1, [fp, #-0x10]
    // 0xefbfe8: r2 = 6
    //     0xefbfe8: movz            x2, #0x6
    // 0xefbfec: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefbfec: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefbff0: r0 = substring()
    //     0xefbff0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefbff4: stur            x0, [fp, #-0x18]
    // 0xefbff8: r16 = 20
    //     0xefbff8: movz            x16, #0x14
    // 0xefbffc: str             x16, [SP]
    // 0xefc000: ldur            x1, [fp, #-0x10]
    // 0xefc004: r2 = 9
    //     0xefc004: movz            x2, #0x9
    // 0xefc008: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc008: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc00c: r0 = substring()
    //     0xefc00c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc010: stur            x0, [fp, #-0x20]
    // 0xefc014: r16 = "01"
    //     0xefc014: add             x16, PP, #0xb, lsl #12  ; [pp+0xbc98] "01"
    //     0xefc018: ldr             x16, [x16, #0xc98]
    // 0xefc01c: ldur            lr, [fp, #-0x18]
    // 0xefc020: stp             lr, x16, [SP]
    // 0xefc024: r0 = ==()
    //     0xefc024: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc028: tbnz            w0, #4, #0xefc03c
    // 0xefc02c: ldur            x1, [fp, #-8]
    // 0xefc030: ldur            x2, [fp, #-0x10]
    // 0xefc034: r0 = _handleKeyData()
    //     0xefc034: bl              #0xefb630  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleKeyData
    // 0xefc038: b               #0xefc230
    // 0xefc03c: r16 = "07"
    //     0xefc03c: add             x16, PP, #0x12, lsl #12  ; [pp+0x128c0] "07"
    //     0xefc040: ldr             x16, [x16, #0x8c0]
    // 0xefc044: ldur            lr, [fp, #-0x18]
    // 0xefc048: stp             lr, x16, [SP]
    // 0xefc04c: r0 = ==()
    //     0xefc04c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc050: tbnz            w0, #4, #0xefc064
    // 0xefc054: ldur            x1, [fp, #-8]
    // 0xefc058: ldur            x2, [fp, #-0x20]
    // 0xefc05c: r0 = _handleTouchControl()
    //     0xefc05c: bl              #0xefcbb8  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleTouchControl
    // 0xefc060: b               #0xefc230
    // 0xefc064: r16 = "08"
    //     0xefc064: add             x16, PP, #0x12, lsl #12  ; [pp+0x128c8] "08"
    //     0xefc068: ldr             x16, [x16, #0x8c8]
    // 0xefc06c: ldur            lr, [fp, #-0x18]
    // 0xefc070: stp             lr, x16, [SP]
    // 0xefc074: r0 = ==()
    //     0xefc074: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc078: tbnz            w0, #4, #0xefc08c
    // 0xefc07c: ldur            x1, [fp, #-8]
    // 0xefc080: ldur            x2, [fp, #-0x20]
    // 0xefc084: r0 = _handleInEarDetection()
    //     0xefc084: bl              #0xefcab4  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleInEarDetection
    // 0xefc088: b               #0xefc230
    // 0xefc08c: r16 = "09"
    //     0xefc08c: add             x16, PP, #0x12, lsl #12  ; [pp+0x128b0] "09"
    //     0xefc090: ldr             x16, [x16, #0x8b0]
    // 0xefc094: ldur            lr, [fp, #-0x18]
    // 0xefc098: stp             lr, x16, [SP]
    // 0xefc09c: r0 = ==()
    //     0xefc09c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc0a0: tbnz            w0, #4, #0xefc0b4
    // 0xefc0a4: ldur            x1, [fp, #-8]
    // 0xefc0a8: ldur            x2, [fp, #-0x20]
    // 0xefc0ac: r0 = _handleANCData()
    //     0xefc0ac: bl              #0xefae78  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleANCData
    // 0xefc0b0: b               #0xefc230
    // 0xefc0b4: r16 = "0c"
    //     0xefc0b4: add             x16, PP, #0x12, lsl #12  ; [pp+0x128b8] "0c"
    //     0xefc0b8: ldr             x16, [x16, #0x8b8]
    // 0xefc0bc: ldur            lr, [fp, #-0x18]
    // 0xefc0c0: stp             lr, x16, [SP]
    // 0xefc0c4: r0 = ==()
    //     0xefc0c4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc0c8: tbnz            w0, #4, #0xefc0dc
    // 0xefc0cc: ldur            x1, [fp, #-8]
    // 0xefc0d0: ldur            x2, [fp, #-0x10]
    // 0xefc0d4: r0 = _handleBatteryData()
    //     0xefc0d4: bl              #0xefc69c  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleBatteryData
    // 0xefc0d8: b               #0xefc230
    // 0xefc0dc: r16 = "0d"
    //     0xefc0dc: add             x16, PP, #0x12, lsl #12  ; [pp+0x128d0] "0d"
    //     0xefc0e0: ldr             x16, [x16, #0x8d0]
    // 0xefc0e4: ldur            lr, [fp, #-0x18]
    // 0xefc0e8: stp             lr, x16, [SP]
    // 0xefc0ec: r0 = ==()
    //     0xefc0ec: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc0f0: tbnz            w0, #4, #0xefc11c
    // 0xefc0f4: r16 = 28
    //     0xefc0f4: movz            x16, #0x1c
    // 0xefc0f8: str             x16, [SP]
    // 0xefc0fc: ldur            x1, [fp, #-0x10]
    // 0xefc100: r2 = 9
    //     0xefc100: movz            x2, #0x9
    // 0xefc104: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc104: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc108: r0 = substring()
    //     0xefc108: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc10c: ldur            x1, [fp, #-8]
    // 0xefc110: mov             x2, x0
    // 0xefc114: r0 = _handleFirmwareVersion()
    //     0xefc114: bl              #0xefc474  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleFirmwareVersion
    // 0xefc118: b               #0xefc230
    // 0xefc11c: r16 = "0e"
    //     0xefc11c: add             x16, PP, #0x12, lsl #12  ; [pp+0x128d8] "0e"
    //     0xefc120: ldr             x16, [x16, #0x8d8]
    // 0xefc124: ldur            lr, [fp, #-0x18]
    // 0xefc128: stp             lr, x16, [SP]
    // 0xefc12c: r0 = ==()
    //     0xefc12c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc130: tbnz            w0, #4, #0xefc144
    // 0xefc134: ldur            x1, [fp, #-8]
    // 0xefc138: ldur            x2, [fp, #-0x20]
    // 0xefc13c: r0 = _handleGameMode()
    //     0xefc13c: bl              #0xefc36c  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleGameMode
    // 0xefc140: b               #0xefc230
    // 0xefc144: r16 = "2a"
    //     0xefc144: add             x16, PP, #0x12, lsl #12  ; [pp+0x128a8] "2a"
    //     0xefc148: ldr             x16, [x16, #0x8a8]
    // 0xefc14c: ldur            lr, [fp, #-0x18]
    // 0xefc150: stp             lr, x16, [SP]
    // 0xefc154: r0 = ==()
    //     0xefc154: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc158: tbnz            w0, #4, #0xefc16c
    // 0xefc15c: ldur            x1, [fp, #-8]
    // 0xefc160: ldur            x2, [fp, #-0x20]
    // 0xefc164: r0 = _handleEQData()
    //     0xefc164: bl              #0xefb7cc  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleEQData
    // 0xefc168: b               #0xefc230
    // 0xefc16c: r16 = "2b"
    //     0xefc16c: add             x16, PP, #0x12, lsl #12  ; [pp+0x128e0] "2b"
    //     0xefc170: ldr             x16, [x16, #0x8e0]
    // 0xefc174: ldur            lr, [fp, #-0x18]
    // 0xefc178: stp             lr, x16, [SP]
    // 0xefc17c: r0 = ==()
    //     0xefc17c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc180: tbnz            w0, #4, #0xefc194
    // 0xefc184: ldur            x1, [fp, #-8]
    // 0xefc188: ldur            x2, [fp, #-0x20]
    // 0xefc18c: r0 = _handleConnectionMode()
    //     0xefc18c: bl              #0xefaf70  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleConnectionMode
    // 0xefc190: b               #0xefc230
    // 0xefc194: r16 = "2c"
    //     0xefc194: add             x16, PP, #0x12, lsl #12  ; [pp+0x128f0] "2c"
    //     0xefc198: ldr             x16, [x16, #0x8f0]
    // 0xefc19c: ldur            lr, [fp, #-0x18]
    // 0xefc1a0: stp             lr, x16, [SP]
    // 0xefc1a4: r0 = ==()
    //     0xefc1a4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc1a8: tbnz            w0, #4, #0xefc1bc
    // 0xefc1ac: ldur            x1, [fp, #-8]
    // 0xefc1b0: ldur            x2, [fp, #-0x20]
    // 0xefc1b4: r0 = _handleANCLevel()
    //     0xefc1b4: bl              #0xefad80  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleANCLevel
    // 0xefc1b8: b               #0xefc230
    // 0xefc1bc: r16 = "2d"
    //     0xefc1bc: add             x16, PP, #0x12, lsl #12  ; [pp+0x128f8] "2d"
    //     0xefc1c0: ldr             x16, [x16, #0x8f8]
    // 0xefc1c4: ldur            lr, [fp, #-0x18]
    // 0xefc1c8: stp             lr, x16, [SP]
    // 0xefc1cc: r0 = ==()
    //     0xefc1cc: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc1d0: tbnz            w0, #4, #0xefc1e4
    // 0xefc1d4: ldur            x1, [fp, #-8]
    // 0xefc1d8: ldur            x2, [fp, #-0x20]
    // 0xefc1dc: r0 = _handleTransparencyLevel()
    //     0xefc1dc: bl              #0xefac88  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handleTransparencyLevel
    // 0xefc1e0: b               #0xefc230
    // 0xefc1e4: r16 = "2e"
    //     0xefc1e4: add             x16, PP, #0x12, lsl #12  ; [pp+0x12900] "2e"
    //     0xefc1e8: ldr             x16, [x16, #0x900]
    // 0xefc1ec: ldur            lr, [fp, #-0x18]
    // 0xefc1f0: stp             lr, x16, [SP]
    // 0xefc1f4: r0 = ==()
    //     0xefc1f4: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc1f8: tbnz            w0, #4, #0xefc20c
    // 0xefc1fc: ldur            x1, [fp, #-8]
    // 0xefc200: ldur            x2, [fp, #-0x20]
    // 0xefc204: r0 = _handlePromptToneLevel()
    //     0xefc204: bl              #0xefab94  ; [package:roselink_bluetooth/commander/receiver/f8_receiver.dart] F8Receiver::_handlePromptToneLevel
    // 0xefc208: b               #0xefc230
    // 0xefc20c: r16 = "33"
    //     0xefc20c: add             x16, PP, #0x12, lsl #12  ; [pp+0x12908] "33"
    //     0xefc210: ldr             x16, [x16, #0x908]
    // 0xefc214: ldur            lr, [fp, #-0x18]
    // 0xefc218: stp             lr, x16, [SP]
    // 0xefc21c: r0 = ==()
    //     0xefc21c: bl              #0xe49c90  ; [dart:core] _OneByteString::==
    // 0xefc220: tbnz            w0, #4, #0xefc24c
    // 0xefc224: ldur            x1, [fp, #-8]
    // 0xefc228: ldur            x2, [fp, #-0x20]
    // 0xefc22c: r0 = _handleSpatialAudio()
    //     0xefc22c: bl              #0xefc264  ; [package:roselink_bluetooth/commander/receiver/rs_common_receiver.dart] RsCommonReceiver::_handleSpatialAudio
    // 0xefc230: ldur            x1, [fp, #-8]
    // 0xefc234: r2 = true
    //     0xefc234: add             x2, NULL, #0x20  ; true
    // 0xefc238: StoreField: r1->field_f = r2
    //     0xefc238: stur            w2, [x1, #0xf]
    // 0xefc23c: r0 = Null
    //     0xefc23c: mov             x0, NULL
    // 0xefc240: LeaveFrame
    //     0xefc240: mov             SP, fp
    //     0xefc244: ldp             fp, lr, [SP], #0x10
    // 0xefc248: ret
    //     0xefc248: ret             
    // 0xefc24c: r0 = Null
    //     0xefc24c: mov             x0, NULL
    // 0xefc250: LeaveFrame
    //     0xefc250: mov             SP, fp
    //     0xefc254: ldp             fp, lr, [SP], #0x10
    // 0xefc258: ret
    //     0xefc258: ret             
    // 0xefc25c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefc25c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefc260: b               #0xefbed8
  }
  _ _handleSpatialAudio(/* No info */) {
    // ** addr: 0xefc264, size: 0x108
    // 0xefc264: EnterFrame
    //     0xefc264: stp             fp, lr, [SP, #-0x10]!
    //     0xefc268: mov             fp, SP
    // 0xefc26c: AllocStack(0x28)
    //     0xefc26c: sub             SP, SP, #0x28
    // 0xefc270: SetupParameters(RsCommonReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefc270: stur            x1, [fp, #-8]
    //     0xefc274: stur            x2, [fp, #-0x10]
    // 0xefc278: CheckStackOverflow
    //     0xefc278: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefc27c: cmp             SP, x16
    //     0xefc280: b.ls            #0xefc358
    // 0xefc284: r0 = LoadStaticField(0x804)
    //     0xefc284: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefc288: ldr             x0, [x0, #0x1008]
    // 0xefc28c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc290: cmp             w0, w16
    // 0xefc294: b.ne            #0xefc2a0
    // 0xefc298: r2 = rsbt
    //     0xefc298: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefc29c: r0 = InitLateFinalStaticField()
    //     0xefc29c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefc2a0: LoadField: r3 = r0->field_1f
    //     0xefc2a0: ldur            w3, [x0, #0x1f]
    // 0xefc2a4: DecompressPointer r3
    //     0xefc2a4: add             x3, x3, HEAP, lsl #32
    // 0xefc2a8: stur            x3, [fp, #-0x18]
    // 0xefc2ac: r1 = Null
    //     0xefc2ac: mov             x1, NULL
    // 0xefc2b0: r2 = 4
    //     0xefc2b0: movz            x2, #0x4
    // 0xefc2b4: r0 = AllocateArray()
    //     0xefc2b4: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc2b8: r16 = "[commander] 空间音效数据获取到了 "
    //     0xefc2b8: add             x16, PP, #0x13, lsl #12  ; [pp+0x13318] "[commander] 空间音效数据获取到了 "
    //     0xefc2bc: ldr             x16, [x16, #0x318]
    // 0xefc2c0: StoreField: r0->field_f = r16
    //     0xefc2c0: stur            w16, [x0, #0xf]
    // 0xefc2c4: ldur            x1, [fp, #-0x10]
    // 0xefc2c8: StoreField: r0->field_13 = r1
    //     0xefc2c8: stur            w1, [x0, #0x13]
    // 0xefc2cc: str             x0, [SP]
    // 0xefc2d0: r0 = _interpolate()
    //     0xefc2d0: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefc2d4: ldur            x1, [fp, #-0x18]
    // 0xefc2d8: mov             x2, x0
    // 0xefc2dc: r0 = i()
    //     0xefc2dc: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefc2e0: ldur            x0, [fp, #-8]
    // 0xefc2e4: LoadField: r1 = r0->field_7
    //     0xefc2e4: ldur            w1, [x0, #7]
    // 0xefc2e8: DecompressPointer r1
    //     0xefc2e8: add             x1, x1, HEAP, lsl #32
    // 0xefc2ec: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc2f0: cmp             w1, w16
    // 0xefc2f4: b.eq            #0xefc360
    // 0xefc2f8: ldur            x0, [fp, #-0x10]
    // 0xefc2fc: stur            x1, [fp, #-0x18]
    // 0xefc300: r2 = LoadClassIdInstr(r0)
    //     0xefc300: ldur            x2, [x0, #-1]
    //     0xefc304: ubfx            x2, x2, #0xc, #0x14
    // 0xefc308: r16 = "1"
    //     0xefc308: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefc30c: ldr             x16, [x16, #0x248]
    // 0xefc310: stp             x16, x0, [SP]
    // 0xefc314: mov             x0, x2
    // 0xefc318: mov             lr, x0
    // 0xefc31c: ldr             lr, [x21, lr, lsl #3]
    // 0xefc320: blr             lr
    // 0xefc324: ldur            x1, [fp, #-0x18]
    // 0xefc328: r2 = LoadClassIdInstr(r1)
    //     0xefc328: ldur            x2, [x1, #-1]
    //     0xefc32c: ubfx            x2, x2, #0xc, #0x14
    // 0xefc330: mov             x16, x0
    // 0xefc334: mov             x0, x2
    // 0xefc338: mov             x2, x16
    // 0xefc33c: r0 = GDT[cid_x0 + -0xa29]()
    //     0xefc33c: sub             lr, x0, #0xa29
    //     0xefc340: ldr             lr, [x21, lr, lsl #3]
    //     0xefc344: blr             lr
    // 0xefc348: r0 = Null
    //     0xefc348: mov             x0, NULL
    // 0xefc34c: LeaveFrame
    //     0xefc34c: mov             SP, fp
    //     0xefc350: ldp             fp, lr, [SP], #0x10
    // 0xefc354: ret
    //     0xefc354: ret             
    // 0xefc358: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefc358: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefc35c: b               #0xefc284
    // 0xefc360: r9 = receiveHandler
    //     0xefc360: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefc364: ldr             x9, [x9, #0x4a8]
    // 0xefc368: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefc368: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleGameMode(/* No info */) {
    // ** addr: 0xefc36c, size: 0x108
    // 0xefc36c: EnterFrame
    //     0xefc36c: stp             fp, lr, [SP, #-0x10]!
    //     0xefc370: mov             fp, SP
    // 0xefc374: AllocStack(0x28)
    //     0xefc374: sub             SP, SP, #0x28
    // 0xefc378: SetupParameters(RsCommonReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefc378: stur            x1, [fp, #-8]
    //     0xefc37c: stur            x2, [fp, #-0x10]
    // 0xefc380: CheckStackOverflow
    //     0xefc380: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefc384: cmp             SP, x16
    //     0xefc388: b.ls            #0xefc460
    // 0xefc38c: r0 = LoadStaticField(0x804)
    //     0xefc38c: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefc390: ldr             x0, [x0, #0x1008]
    // 0xefc394: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc398: cmp             w0, w16
    // 0xefc39c: b.ne            #0xefc3a8
    // 0xefc3a0: r2 = rsbt
    //     0xefc3a0: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefc3a4: r0 = InitLateFinalStaticField()
    //     0xefc3a4: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefc3a8: LoadField: r3 = r0->field_1f
    //     0xefc3a8: ldur            w3, [x0, #0x1f]
    // 0xefc3ac: DecompressPointer r3
    //     0xefc3ac: add             x3, x3, HEAP, lsl #32
    // 0xefc3b0: stur            x3, [fp, #-0x18]
    // 0xefc3b4: r1 = Null
    //     0xefc3b4: mov             x1, NULL
    // 0xefc3b8: r2 = 4
    //     0xefc3b8: movz            x2, #0x4
    // 0xefc3bc: r0 = AllocateArray()
    //     0xefc3bc: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc3c0: r16 = "[commander] 游戏模式 "
    //     0xefc3c0: add             x16, PP, #0x13, lsl #12  ; [pp+0x13358] "[commander] 游戏模式 "
    //     0xefc3c4: ldr             x16, [x16, #0x358]
    // 0xefc3c8: StoreField: r0->field_f = r16
    //     0xefc3c8: stur            w16, [x0, #0xf]
    // 0xefc3cc: ldur            x1, [fp, #-0x10]
    // 0xefc3d0: StoreField: r0->field_13 = r1
    //     0xefc3d0: stur            w1, [x0, #0x13]
    // 0xefc3d4: str             x0, [SP]
    // 0xefc3d8: r0 = _interpolate()
    //     0xefc3d8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefc3dc: ldur            x1, [fp, #-0x18]
    // 0xefc3e0: mov             x2, x0
    // 0xefc3e4: r0 = i()
    //     0xefc3e4: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefc3e8: ldur            x0, [fp, #-8]
    // 0xefc3ec: LoadField: r1 = r0->field_7
    //     0xefc3ec: ldur            w1, [x0, #7]
    // 0xefc3f0: DecompressPointer r1
    //     0xefc3f0: add             x1, x1, HEAP, lsl #32
    // 0xefc3f4: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc3f8: cmp             w1, w16
    // 0xefc3fc: b.eq            #0xefc468
    // 0xefc400: ldur            x0, [fp, #-0x10]
    // 0xefc404: stur            x1, [fp, #-0x18]
    // 0xefc408: r2 = LoadClassIdInstr(r0)
    //     0xefc408: ldur            x2, [x0, #-1]
    //     0xefc40c: ubfx            x2, x2, #0xc, #0x14
    // 0xefc410: r16 = "1"
    //     0xefc410: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefc414: ldr             x16, [x16, #0x248]
    // 0xefc418: stp             x16, x0, [SP]
    // 0xefc41c: mov             x0, x2
    // 0xefc420: mov             lr, x0
    // 0xefc424: ldr             lr, [x21, lr, lsl #3]
    // 0xefc428: blr             lr
    // 0xefc42c: ldur            x1, [fp, #-0x18]
    // 0xefc430: r2 = LoadClassIdInstr(r1)
    //     0xefc430: ldur            x2, [x1, #-1]
    //     0xefc434: ubfx            x2, x2, #0xc, #0x14
    // 0xefc438: mov             x16, x0
    // 0xefc43c: mov             x0, x2
    // 0xefc440: mov             x2, x16
    // 0xefc444: r0 = GDT[cid_x0 + -0xb8a]()
    //     0xefc444: sub             lr, x0, #0xb8a
    //     0xefc448: ldr             lr, [x21, lr, lsl #3]
    //     0xefc44c: blr             lr
    // 0xefc450: r0 = Null
    //     0xefc450: mov             x0, NULL
    // 0xefc454: LeaveFrame
    //     0xefc454: mov             SP, fp
    //     0xefc458: ldp             fp, lr, [SP], #0x10
    // 0xefc45c: ret
    //     0xefc45c: ret             
    // 0xefc460: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefc460: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefc464: b               #0xefc38c
    // 0xefc468: r9 = receiveHandler
    //     0xefc468: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefc46c: ldr             x9, [x9, #0x4a8]
    // 0xefc470: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefc470: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleFirmwareVersion(/* No info */) {
    // ** addr: 0xefc474, size: 0x228
    // 0xefc474: EnterFrame
    //     0xefc474: stp             fp, lr, [SP, #-0x10]!
    //     0xefc478: mov             fp, SP
    // 0xefc47c: AllocStack(0x48)
    //     0xefc47c: sub             SP, SP, #0x48
    // 0xefc480: SetupParameters(RsCommonReceiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xefc480: mov             x3, x1
    //     0xefc484: mov             x0, x2
    //     0xefc488: stur            x1, [fp, #-8]
    //     0xefc48c: stur            x2, [fp, #-0x10]
    // 0xefc490: CheckStackOverflow
    //     0xefc490: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefc494: cmp             SP, x16
    //     0xefc498: b.ls            #0xefc688
    // 0xefc49c: r16 = 2
    //     0xefc49c: movz            x16, #0x2
    // 0xefc4a0: str             x16, [SP]
    // 0xefc4a4: mov             x1, x0
    // 0xefc4a8: r2 = 0
    //     0xefc4a8: movz            x2, #0
    // 0xefc4ac: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc4ac: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc4b0: r0 = substring()
    //     0xefc4b0: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc4b4: r16 = 32
    //     0xefc4b4: movz            x16, #0x20
    // 0xefc4b8: str             x16, [SP]
    // 0xefc4bc: mov             x1, x0
    // 0xefc4c0: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc4c0: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc4c4: ldr             x4, [x4, #0x128]
    // 0xefc4c8: r0 = parse()
    //     0xefc4c8: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc4cc: stur            x0, [fp, #-0x18]
    // 0xefc4d0: r16 = 6
    //     0xefc4d0: movz            x16, #0x6
    // 0xefc4d4: str             x16, [SP]
    // 0xefc4d8: ldur            x1, [fp, #-0x10]
    // 0xefc4dc: r2 = 2
    //     0xefc4dc: movz            x2, #0x2
    // 0xefc4e0: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc4e0: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc4e4: r0 = substring()
    //     0xefc4e4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc4e8: r16 = 32
    //     0xefc4e8: movz            x16, #0x20
    // 0xefc4ec: str             x16, [SP]
    // 0xefc4f0: mov             x1, x0
    // 0xefc4f4: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc4f4: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc4f8: ldr             x4, [x4, #0x128]
    // 0xefc4fc: r0 = parse()
    //     0xefc4fc: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc500: stur            x0, [fp, #-0x20]
    // 0xefc504: r16 = 10
    //     0xefc504: movz            x16, #0xa
    // 0xefc508: str             x16, [SP]
    // 0xefc50c: ldur            x1, [fp, #-0x10]
    // 0xefc510: r2 = 4
    //     0xefc510: movz            x2, #0x4
    // 0xefc514: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc514: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc518: r0 = substring()
    //     0xefc518: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc51c: r16 = 32
    //     0xefc51c: movz            x16, #0x20
    // 0xefc520: str             x16, [SP]
    // 0xefc524: mov             x1, x0
    // 0xefc528: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc528: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc52c: ldr             x4, [x4, #0x128]
    // 0xefc530: r0 = parse()
    //     0xefc530: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc534: stur            x0, [fp, #-0x28]
    // 0xefc538: r0 = LoadStaticField(0x804)
    //     0xefc538: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefc53c: ldr             x0, [x0, #0x1008]
    // 0xefc540: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc544: cmp             w0, w16
    // 0xefc548: b.ne            #0xefc554
    // 0xefc54c: r2 = rsbt
    //     0xefc54c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefc550: r0 = InitLateFinalStaticField()
    //     0xefc550: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefc554: LoadField: r3 = r0->field_1f
    //     0xefc554: ldur            w3, [x0, #0x1f]
    // 0xefc558: DecompressPointer r3
    //     0xefc558: add             x3, x3, HEAP, lsl #32
    // 0xefc55c: stur            x3, [fp, #-0x10]
    // 0xefc560: r1 = Null
    //     0xefc560: mov             x1, NULL
    // 0xefc564: r2 = 12
    //     0xefc564: movz            x2, #0xc
    // 0xefc568: r0 = AllocateArray()
    //     0xefc568: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc56c: mov             x2, x0
    // 0xefc570: r16 = "[commander] 固件版本数据 "
    //     0xefc570: add             x16, PP, #0x13, lsl #12  ; [pp+0x13370] "[commander] 固件版本数据 "
    //     0xefc574: ldr             x16, [x16, #0x370]
    // 0xefc578: StoreField: r2->field_f = r16
    //     0xefc578: stur            w16, [x2, #0xf]
    // 0xefc57c: ldur            x3, [fp, #-0x18]
    // 0xefc580: r0 = BoxInt64Instr(r3)
    //     0xefc580: sbfiz           x0, x3, #1, #0x1f
    //     0xefc584: cmp             x3, x0, asr #1
    //     0xefc588: b.eq            #0xefc594
    //     0xefc58c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefc590: stur            x3, [x0, #7]
    // 0xefc594: mov             x3, x0
    // 0xefc598: stur            x3, [fp, #-0x40]
    // 0xefc59c: StoreField: r2->field_13 = r3
    //     0xefc59c: stur            w3, [x2, #0x13]
    // 0xefc5a0: r16 = " "
    //     0xefc5a0: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc5a4: ArrayStore: r2[0] = r16  ; List_4
    //     0xefc5a4: stur            w16, [x2, #0x17]
    // 0xefc5a8: ldur            x4, [fp, #-0x20]
    // 0xefc5ac: r0 = BoxInt64Instr(r4)
    //     0xefc5ac: sbfiz           x0, x4, #1, #0x1f
    //     0xefc5b0: cmp             x4, x0, asr #1
    //     0xefc5b4: b.eq            #0xefc5c0
    //     0xefc5b8: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefc5bc: stur            x4, [x0, #7]
    // 0xefc5c0: mov             x4, x0
    // 0xefc5c4: stur            x4, [fp, #-0x38]
    // 0xefc5c8: StoreField: r2->field_1b = r4
    //     0xefc5c8: stur            w4, [x2, #0x1b]
    // 0xefc5cc: r16 = " "
    //     0xefc5cc: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc5d0: StoreField: r2->field_1f = r16
    //     0xefc5d0: stur            w16, [x2, #0x1f]
    // 0xefc5d4: ldur            x5, [fp, #-0x28]
    // 0xefc5d8: r0 = BoxInt64Instr(r5)
    //     0xefc5d8: sbfiz           x0, x5, #1, #0x1f
    //     0xefc5dc: cmp             x5, x0, asr #1
    //     0xefc5e0: b.eq            #0xefc5ec
    //     0xefc5e4: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefc5e8: stur            x5, [x0, #7]
    // 0xefc5ec: stur            x0, [fp, #-0x30]
    // 0xefc5f0: StoreField: r2->field_23 = r0
    //     0xefc5f0: stur            w0, [x2, #0x23]
    // 0xefc5f4: str             x2, [SP]
    // 0xefc5f8: r0 = _interpolate()
    //     0xefc5f8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefc5fc: ldur            x1, [fp, #-0x10]
    // 0xefc600: mov             x2, x0
    // 0xefc604: r0 = i()
    //     0xefc604: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefc608: ldur            x0, [fp, #-8]
    // 0xefc60c: LoadField: r3 = r0->field_7
    //     0xefc60c: ldur            w3, [x0, #7]
    // 0xefc610: DecompressPointer r3
    //     0xefc610: add             x3, x3, HEAP, lsl #32
    // 0xefc614: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc618: cmp             w3, w16
    // 0xefc61c: b.eq            #0xefc690
    // 0xefc620: stur            x3, [fp, #-0x10]
    // 0xefc624: r1 = Null
    //     0xefc624: mov             x1, NULL
    // 0xefc628: r2 = 6
    //     0xefc628: movz            x2, #0x6
    // 0xefc62c: r0 = AllocateArray()
    //     0xefc62c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc630: mov             x1, x0
    // 0xefc634: ldur            x0, [fp, #-0x40]
    // 0xefc638: StoreField: r1->field_f = r0
    //     0xefc638: stur            w0, [x1, #0xf]
    // 0xefc63c: ldur            x0, [fp, #-0x38]
    // 0xefc640: StoreField: r1->field_13 = r0
    //     0xefc640: stur            w0, [x1, #0x13]
    // 0xefc644: ldur            x0, [fp, #-0x30]
    // 0xefc648: ArrayStore: r1[0] = r0  ; List_4
    //     0xefc648: stur            w0, [x1, #0x17]
    // 0xefc64c: str             x1, [SP]
    // 0xefc650: r0 = _interpolate()
    //     0xefc650: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefc654: ldur            x1, [fp, #-0x10]
    // 0xefc658: r2 = LoadClassIdInstr(r1)
    //     0xefc658: ldur            x2, [x1, #-1]
    //     0xefc65c: ubfx            x2, x2, #0xc, #0x14
    // 0xefc660: mov             x16, x0
    // 0xefc664: mov             x0, x2
    // 0xefc668: mov             x2, x16
    // 0xefc66c: r0 = GDT[cid_x0 + -0xb98]()
    //     0xefc66c: sub             lr, x0, #0xb98
    //     0xefc670: ldr             lr, [x21, lr, lsl #3]
    //     0xefc674: blr             lr
    // 0xefc678: r0 = Null
    //     0xefc678: mov             x0, NULL
    // 0xefc67c: LeaveFrame
    //     0xefc67c: mov             SP, fp
    //     0xefc680: ldp             fp, lr, [SP], #0x10
    // 0xefc684: ret
    //     0xefc684: ret             
    // 0xefc688: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefc688: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefc68c: b               #0xefc49c
    // 0xefc690: r9 = receiveHandler
    //     0xefc690: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefc694: ldr             x9, [x9, #0x4a8]
    // 0xefc698: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefc698: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleBatteryData(/* No info */) {
    // ** addr: 0xefc69c, size: 0x418
    // 0xefc69c: EnterFrame
    //     0xefc69c: stp             fp, lr, [SP, #-0x10]!
    //     0xefc6a0: mov             fp, SP
    // 0xefc6a4: AllocStack(0x78)
    //     0xefc6a4: sub             SP, SP, #0x78
    // 0xefc6a8: SetupParameters(RsCommonReceiver this /* r1 => r3, fp-0x8 */, dynamic _ /* r2 => r0, fp-0x10 */)
    //     0xefc6a8: mov             x3, x1
    //     0xefc6ac: mov             x0, x2
    //     0xefc6b0: stur            x1, [fp, #-8]
    //     0xefc6b4: stur            x2, [fp, #-0x10]
    // 0xefc6b8: CheckStackOverflow
    //     0xefc6b8: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefc6bc: cmp             SP, x16
    //     0xefc6c0: b.ls            #0xefcaa0
    // 0xefc6c4: r16 = 20
    //     0xefc6c4: movz            x16, #0x14
    // 0xefc6c8: str             x16, [SP]
    // 0xefc6cc: mov             x1, x0
    // 0xefc6d0: r2 = 8
    //     0xefc6d0: movz            x2, #0x8
    // 0xefc6d4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc6d4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc6d8: r0 = substring()
    //     0xefc6d8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc6dc: stur            x0, [fp, #-0x18]
    // 0xefc6e0: r16 = 24
    //     0xefc6e0: movz            x16, #0x18
    // 0xefc6e4: str             x16, [SP]
    // 0xefc6e8: ldur            x1, [fp, #-0x10]
    // 0xefc6ec: r2 = 10
    //     0xefc6ec: movz            x2, #0xa
    // 0xefc6f0: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc6f0: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc6f4: r0 = substring()
    //     0xefc6f4: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc6f8: stur            x0, [fp, #-0x20]
    // 0xefc6fc: r16 = 28
    //     0xefc6fc: movz            x16, #0x1c
    // 0xefc700: str             x16, [SP]
    // 0xefc704: ldur            x1, [fp, #-0x10]
    // 0xefc708: r2 = 12
    //     0xefc708: movz            x2, #0xc
    // 0xefc70c: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc70c: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc710: r0 = substring()
    //     0xefc710: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc714: stur            x0, [fp, #-0x28]
    // 0xefc718: r0 = LoadStaticField(0x804)
    //     0xefc718: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefc71c: ldr             x0, [x0, #0x1008]
    // 0xefc720: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc724: cmp             w0, w16
    // 0xefc728: b.ne            #0xefc734
    // 0xefc72c: r2 = rsbt
    //     0xefc72c: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefc730: r0 = InitLateFinalStaticField()
    //     0xefc730: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefc734: stur            x0, [fp, #-0x38]
    // 0xefc738: LoadField: r3 = r0->field_1f
    //     0xefc738: ldur            w3, [x0, #0x1f]
    // 0xefc73c: DecompressPointer r3
    //     0xefc73c: add             x3, x3, HEAP, lsl #32
    // 0xefc740: stur            x3, [fp, #-0x30]
    // 0xefc744: r1 = Null
    //     0xefc744: mov             x1, NULL
    // 0xefc748: r2 = 12
    //     0xefc748: movz            x2, #0xc
    // 0xefc74c: r0 = AllocateArray()
    //     0xefc74c: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc750: r16 = "[commander] 电量数据: "
    //     0xefc750: add             x16, PP, #0x13, lsl #12  ; [pp+0x133b0] "[commander] 电量数据: "
    //     0xefc754: ldr             x16, [x16, #0x3b0]
    // 0xefc758: StoreField: r0->field_f = r16
    //     0xefc758: stur            w16, [x0, #0xf]
    // 0xefc75c: ldur            x1, [fp, #-0x18]
    // 0xefc760: StoreField: r0->field_13 = r1
    //     0xefc760: stur            w1, [x0, #0x13]
    // 0xefc764: r16 = " "
    //     0xefc764: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc768: ArrayStore: r0[0] = r16  ; List_4
    //     0xefc768: stur            w16, [x0, #0x17]
    // 0xefc76c: ldur            x2, [fp, #-0x20]
    // 0xefc770: StoreField: r0->field_1b = r2
    //     0xefc770: stur            w2, [x0, #0x1b]
    // 0xefc774: r16 = " "
    //     0xefc774: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc778: StoreField: r0->field_1f = r16
    //     0xefc778: stur            w16, [x0, #0x1f]
    // 0xefc77c: ldur            x3, [fp, #-0x28]
    // 0xefc780: StoreField: r0->field_23 = r3
    //     0xefc780: stur            w3, [x0, #0x23]
    // 0xefc784: str             x0, [SP]
    // 0xefc788: r0 = _interpolate()
    //     0xefc788: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefc78c: ldur            x1, [fp, #-0x30]
    // 0xefc790: mov             x2, x0
    // 0xefc794: r0 = i()
    //     0xefc794: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefc798: r16 = 32
    //     0xefc798: movz            x16, #0x20
    // 0xefc79c: str             x16, [SP]
    // 0xefc7a0: ldur            x1, [fp, #-0x18]
    // 0xefc7a4: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc7a4: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc7a8: ldr             x4, [x4, #0x128]
    // 0xefc7ac: r0 = parse()
    //     0xefc7ac: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc7b0: mov             x2, x0
    // 0xefc7b4: r0 = BoxInt64Instr(r2)
    //     0xefc7b4: sbfiz           x0, x2, #1, #0x1f
    //     0xefc7b8: cmp             x2, x0, asr #1
    //     0xefc7bc: b.eq            #0xefc7c8
    //     0xefc7c0: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefc7c4: stur            x2, [x0, #7]
    // 0xefc7c8: mov             x1, x0
    // 0xefc7cc: r2 = 2
    //     0xefc7cc: movz            x2, #0x2
    // 0xefc7d0: r0 = _toPow2String()
    //     0xefc7d0: bl              #0x6511a4  ; [dart:core] _IntegerImplementation::_toPow2String
    // 0xefc7d4: mov             x1, x0
    // 0xefc7d8: ldur            x0, [fp, #-0x18]
    // 0xefc7dc: LoadField: r2 = r0->field_7
    //     0xefc7dc: ldur            w2, [x0, #7]
    // 0xefc7e0: r3 = LoadInt32Instr(r2)
    //     0xefc7e0: sbfx            x3, x2, #1, #0x1f
    // 0xefc7e4: lsl             x2, x3, #2
    // 0xefc7e8: r3 = "0"
    //     0xefc7e8: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefc7ec: r0 = padLeft()
    //     0xefc7ec: bl              #0xf1b814  ; [dart:core] _OneByteString::padLeft
    // 0xefc7f0: stur            x0, [fp, #-0x30]
    // 0xefc7f4: r16 = 32
    //     0xefc7f4: movz            x16, #0x20
    // 0xefc7f8: str             x16, [SP]
    // 0xefc7fc: ldur            x1, [fp, #-0x20]
    // 0xefc800: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc800: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc804: ldr             x4, [x4, #0x128]
    // 0xefc808: r0 = parse()
    //     0xefc808: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc80c: mov             x2, x0
    // 0xefc810: r0 = BoxInt64Instr(r2)
    //     0xefc810: sbfiz           x0, x2, #1, #0x1f
    //     0xefc814: cmp             x2, x0, asr #1
    //     0xefc818: b.eq            #0xefc824
    //     0xefc81c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xefc820: stur            x2, [x0, #7]
    // 0xefc824: mov             x1, x0
    // 0xefc828: r2 = 2
    //     0xefc828: movz            x2, #0x2
    // 0xefc82c: r0 = _toPow2String()
    //     0xefc82c: bl              #0x6511a4  ; [dart:core] _IntegerImplementation::_toPow2String
    // 0xefc830: mov             x1, x0
    // 0xefc834: ldur            x0, [fp, #-0x20]
    // 0xefc838: LoadField: r2 = r0->field_7
    //     0xefc838: ldur            w2, [x0, #7]
    // 0xefc83c: r3 = LoadInt32Instr(r2)
    //     0xefc83c: sbfx            x3, x2, #1, #0x1f
    // 0xefc840: lsl             x2, x3, #2
    // 0xefc844: r3 = "0"
    //     0xefc844: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefc848: r0 = padLeft()
    //     0xefc848: bl              #0xf1b814  ; [dart:core] _OneByteString::padLeft
    // 0xefc84c: ldur            x1, [fp, #-0x30]
    // 0xefc850: r2 = 1
    //     0xefc850: movz            x2, #0x1
    // 0xefc854: stur            x0, [fp, #-0x40]
    // 0xefc858: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefc858: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefc85c: r0 = substring()
    //     0xefc85c: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc860: r16 = 4
    //     0xefc860: movz            x16, #0x4
    // 0xefc864: str             x16, [SP]
    // 0xefc868: mov             x1, x0
    // 0xefc86c: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc86c: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc870: ldr             x4, [x4, #0x128]
    // 0xefc874: r0 = parse()
    //     0xefc874: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc878: ldur            x1, [fp, #-0x40]
    // 0xefc87c: r2 = 1
    //     0xefc87c: movz            x2, #0x1
    // 0xefc880: stur            x0, [fp, #-0x48]
    // 0xefc884: r4 = const [0, 0x2, 0, 0x2, null]
    //     0xefc884: ldr             x4, [PP, #0x5b0]  ; [pp+0x5b0] List(5) [0, 0x2, 0, 0x2, Null]
    // 0xefc888: r0 = substring()
    //     0xefc888: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc88c: r16 = 4
    //     0xefc88c: movz            x16, #0x4
    // 0xefc890: str             x16, [SP]
    // 0xefc894: mov             x1, x0
    // 0xefc898: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc898: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc89c: ldr             x4, [x4, #0x128]
    // 0xefc8a0: r0 = parse()
    //     0xefc8a0: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc8a4: stur            x0, [fp, #-0x50]
    // 0xefc8a8: r16 = 32
    //     0xefc8a8: movz            x16, #0x20
    // 0xefc8ac: str             x16, [SP]
    // 0xefc8b0: ldur            x1, [fp, #-0x28]
    // 0xefc8b4: r4 = const [0, 0x2, 0x1, 0x1, radix, 0x1, null]
    //     0xefc8b4: add             x4, PP, #0xa, lsl #12  ; [pp+0xa128] List(7) [0, 0x2, 0x1, 0x1, "radix", 0x1, Null]
    //     0xefc8b8: ldr             x4, [x4, #0x128]
    // 0xefc8bc: r0 = parse()
    //     0xefc8bc: bl              #0x621868  ; [dart:core] int::parse
    // 0xefc8c0: stur            x0, [fp, #-0x58]
    // 0xefc8c4: r16 = 2
    //     0xefc8c4: movz            x16, #0x2
    // 0xefc8c8: str             x16, [SP]
    // 0xefc8cc: ldur            x1, [fp, #-0x30]
    // 0xefc8d0: r2 = 0
    //     0xefc8d0: movz            x2, #0
    // 0xefc8d4: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc8d4: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc8d8: r0 = substring()
    //     0xefc8d8: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc8dc: r1 = LoadClassIdInstr(r0)
    //     0xefc8dc: ldur            x1, [x0, #-1]
    //     0xefc8e0: ubfx            x1, x1, #0xc, #0x14
    // 0xefc8e4: r16 = "1"
    //     0xefc8e4: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefc8e8: ldr             x16, [x16, #0x248]
    // 0xefc8ec: stp             x16, x0, [SP]
    // 0xefc8f0: mov             x0, x1
    // 0xefc8f4: mov             lr, x0
    // 0xefc8f8: ldr             lr, [x21, lr, lsl #3]
    // 0xefc8fc: blr             lr
    // 0xefc900: stur            x0, [fp, #-0x60]
    // 0xefc904: r16 = 2
    //     0xefc904: movz            x16, #0x2
    // 0xefc908: str             x16, [SP]
    // 0xefc90c: ldur            x1, [fp, #-0x40]
    // 0xefc910: r2 = 0
    //     0xefc910: movz            x2, #0
    // 0xefc914: r4 = const [0, 0x3, 0x1, 0x3, null]
    //     0xefc914: ldr             x4, [PP, #0x418]  ; [pp+0x418] List(5) [0, 0x3, 0x1, 0x3, Null]
    // 0xefc918: r0 = substring()
    //     0xefc918: bl              #0x607594  ; [dart:core] _StringBase::substring
    // 0xefc91c: r1 = LoadClassIdInstr(r0)
    //     0xefc91c: ldur            x1, [x0, #-1]
    //     0xefc920: ubfx            x1, x1, #0xc, #0x14
    // 0xefc924: r16 = "1"
    //     0xefc924: add             x16, PP, #0x10, lsl #12  ; [pp+0x10248] "1"
    //     0xefc928: ldr             x16, [x16, #0x248]
    // 0xefc92c: stp             x16, x0, [SP]
    // 0xefc930: mov             x0, x1
    // 0xefc934: mov             lr, x0
    // 0xefc938: ldr             lr, [x21, lr, lsl #3]
    // 0xefc93c: blr             lr
    // 0xefc940: stur            x0, [fp, #-0x68]
    // 0xefc944: r0 = RBatteryData()
    //     0xefc944: bl              #0xefbe0c  ; AllocateRBatteryDataStub -> RBatteryData (size=0x2c)
    // 0xefc948: mov             x1, x0
    // 0xefc94c: ldur            x0, [fp, #-0x48]
    // 0xefc950: StoreField: r1->field_7 = r0
    //     0xefc950: stur            x0, [x1, #7]
    // 0xefc954: ldur            x0, [fp, #-0x50]
    // 0xefc958: StoreField: r1->field_f = r0
    //     0xefc958: stur            x0, [x1, #0xf]
    // 0xefc95c: ldur            x0, [fp, #-0x58]
    // 0xefc960: ArrayStore: r1[0] = r0  ; List_8
    //     0xefc960: stur            x0, [x1, #0x17]
    // 0xefc964: ldur            x4, [fp, #-0x60]
    // 0xefc968: StoreField: r1->field_1f = r4
    //     0xefc968: stur            w4, [x1, #0x1f]
    // 0xefc96c: ldur            x5, [fp, #-0x68]
    // 0xefc970: StoreField: r1->field_23 = r5
    //     0xefc970: stur            w5, [x1, #0x23]
    // 0xefc974: r0 = false
    //     0xefc974: add             x0, NULL, #0x30  ; false
    // 0xefc978: StoreField: r1->field_27 = r0
    //     0xefc978: stur            w0, [x1, #0x27]
    // 0xefc97c: ldur            x0, [fp, #-8]
    // 0xefc980: LoadField: r2 = r0->field_7
    //     0xefc980: ldur            w2, [x0, #7]
    // 0xefc984: DecompressPointer r2
    //     0xefc984: add             x2, x2, HEAP, lsl #32
    // 0xefc988: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefc98c: cmp             w2, w16
    // 0xefc990: b.eq            #0xefcaa8
    // 0xefc994: r0 = LoadClassIdInstr(r2)
    //     0xefc994: ldur            x0, [x2, #-1]
    //     0xefc998: ubfx            x0, x0, #0xc, #0x14
    // 0xefc99c: mov             x16, x1
    // 0xefc9a0: mov             x1, x2
    // 0xefc9a4: mov             x2, x16
    // 0xefc9a8: ldur            x3, [fp, #-0x10]
    // 0xefc9ac: r0 = GDT[cid_x0 + -0xf7d]()
    //     0xefc9ac: sub             lr, x0, #0xf7d
    //     0xefc9b0: ldr             lr, [x21, lr, lsl #3]
    //     0xefc9b4: blr             lr
    // 0xefc9b8: ldur            x0, [fp, #-0x38]
    // 0xefc9bc: LoadField: r3 = r0->field_1f
    //     0xefc9bc: ldur            w3, [x0, #0x1f]
    // 0xefc9c0: DecompressPointer r3
    //     0xefc9c0: add             x3, x3, HEAP, lsl #32
    // 0xefc9c4: stur            x3, [fp, #-8]
    // 0xefc9c8: r1 = Null
    //     0xefc9c8: mov             x1, NULL
    // 0xefc9cc: r2 = 40
    //     0xefc9cc: movz            x2, #0x28
    // 0xefc9d0: r0 = AllocateArray()
    //     0xefc9d0: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefc9d4: r16 = "[commander] 电量数据 原始数据 "
    //     0xefc9d4: add             x16, PP, #0x13, lsl #12  ; [pp+0x133b8] "[commander] 电量数据 原始数据 "
    //     0xefc9d8: ldr             x16, [x16, #0x3b8]
    // 0xefc9dc: StoreField: r0->field_f = r16
    //     0xefc9dc: stur            w16, [x0, #0xf]
    // 0xefc9e0: ldur            x1, [fp, #-0x18]
    // 0xefc9e4: StoreField: r0->field_13 = r1
    //     0xefc9e4: stur            w1, [x0, #0x13]
    // 0xefc9e8: r16 = " "
    //     0xefc9e8: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc9ec: ArrayStore: r0[0] = r16  ; List_4
    //     0xefc9ec: stur            w16, [x0, #0x17]
    // 0xefc9f0: ldur            x2, [fp, #-0x20]
    // 0xefc9f4: StoreField: r0->field_1b = r2
    //     0xefc9f4: stur            w2, [x0, #0x1b]
    // 0xefc9f8: r16 = " "
    //     0xefc9f8: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefc9fc: StoreField: r0->field_1f = r16
    //     0xefc9fc: stur            w16, [x0, #0x1f]
    // 0xefca00: ldur            x3, [fp, #-0x28]
    // 0xefca04: StoreField: r0->field_23 = r3
    //     0xefca04: stur            w3, [x0, #0x23]
    // 0xefca08: r16 = " 十六进制原始数据："
    //     0xefca08: add             x16, PP, #0x12, lsl #12  ; [pp+0x125a0] " 十六进制原始数据："
    //     0xefca0c: ldr             x16, [x16, #0x5a0]
    // 0xefca10: StoreField: r0->field_27 = r16
    //     0xefca10: stur            w16, [x0, #0x27]
    // 0xefca14: StoreField: r0->field_2b = r1
    //     0xefca14: stur            w1, [x0, #0x2b]
    // 0xefca18: r16 = " "
    //     0xefca18: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefca1c: StoreField: r0->field_2f = r16
    //     0xefca1c: stur            w16, [x0, #0x2f]
    // 0xefca20: StoreField: r0->field_33 = r2
    //     0xefca20: stur            w2, [x0, #0x33]
    // 0xefca24: r16 = " "
    //     0xefca24: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefca28: StoreField: r0->field_37 = r16
    //     0xefca28: stur            w16, [x0, #0x37]
    // 0xefca2c: StoreField: r0->field_3b = r3
    //     0xefca2c: stur            w3, [x0, #0x3b]
    // 0xefca30: r16 = " 左耳二进制下数据"
    //     0xefca30: add             x16, PP, #0x13, lsl #12  ; [pp+0x133c0] " 左耳二进制下数据"
    //     0xefca34: ldr             x16, [x16, #0x3c0]
    // 0xefca38: StoreField: r0->field_3f = r16
    //     0xefca38: stur            w16, [x0, #0x3f]
    // 0xefca3c: ldur            x1, [fp, #-0x30]
    // 0xefca40: StoreField: r0->field_43 = r1
    //     0xefca40: stur            w1, [x0, #0x43]
    // 0xefca44: r16 = " 右耳二进制数据"
    //     0xefca44: add             x16, PP, #0x13, lsl #12  ; [pp+0x133c8] " 右耳二进制数据"
    //     0xefca48: ldr             x16, [x16, #0x3c8]
    // 0xefca4c: StoreField: r0->field_47 = r16
    //     0xefca4c: stur            w16, [x0, #0x47]
    // 0xefca50: ldur            x1, [fp, #-0x40]
    // 0xefca54: StoreField: r0->field_4b = r1
    //     0xefca54: stur            w1, [x0, #0x4b]
    // 0xefca58: r16 = " 人仓L/R "
    //     0xefca58: add             x16, PP, #0x13, lsl #12  ; [pp+0x133d0] " 人仓L/R "
    //     0xefca5c: ldr             x16, [x16, #0x3d0]
    // 0xefca60: StoreField: r0->field_4f = r16
    //     0xefca60: stur            w16, [x0, #0x4f]
    // 0xefca64: ldur            x1, [fp, #-0x60]
    // 0xefca68: StoreField: r0->field_53 = r1
    //     0xefca68: stur            w1, [x0, #0x53]
    // 0xefca6c: r16 = " "
    //     0xefca6c: ldr             x16, [PP, #0x7e0]  ; [pp+0x7e0] " "
    // 0xefca70: StoreField: r0->field_57 = r16
    //     0xefca70: stur            w16, [x0, #0x57]
    // 0xefca74: ldur            x1, [fp, #-0x68]
    // 0xefca78: StoreField: r0->field_5b = r1
    //     0xefca78: stur            w1, [x0, #0x5b]
    // 0xefca7c: str             x0, [SP]
    // 0xefca80: r0 = _interpolate()
    //     0xefca80: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefca84: ldur            x1, [fp, #-8]
    // 0xefca88: mov             x2, x0
    // 0xefca8c: r0 = t()
    //     0xefca8c: bl              #0x798af0  ; [package:logger/src/logger.dart] Logger::t
    // 0xefca90: r0 = Null
    //     0xefca90: mov             x0, NULL
    // 0xefca94: LeaveFrame
    //     0xefca94: mov             SP, fp
    //     0xefca98: ldp             fp, lr, [SP], #0x10
    // 0xefca9c: ret
    //     0xefca9c: ret             
    // 0xefcaa0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefcaa0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefcaa4: b               #0xefc6c4
    // 0xefcaa8: r9 = receiveHandler
    //     0xefcaa8: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefcaac: ldr             x9, [x9, #0x4a8]
    // 0xefcab0: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefcab0: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleInEarDetection(/* No info */) {
    // ** addr: 0xefcab4, size: 0x104
    // 0xefcab4: EnterFrame
    //     0xefcab4: stp             fp, lr, [SP, #-0x10]!
    //     0xefcab8: mov             fp, SP
    // 0xefcabc: AllocStack(0x28)
    //     0xefcabc: sub             SP, SP, #0x28
    // 0xefcac0: SetupParameters(RsCommonReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefcac0: stur            x1, [fp, #-8]
    //     0xefcac4: stur            x2, [fp, #-0x10]
    // 0xefcac8: CheckStackOverflow
    //     0xefcac8: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefcacc: cmp             SP, x16
    //     0xefcad0: b.ls            #0xefcba4
    // 0xefcad4: r0 = LoadStaticField(0x804)
    //     0xefcad4: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefcad8: ldr             x0, [x0, #0x1008]
    // 0xefcadc: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefcae0: cmp             w0, w16
    // 0xefcae4: b.ne            #0xefcaf0
    // 0xefcae8: r2 = rsbt
    //     0xefcae8: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefcaec: r0 = InitLateFinalStaticField()
    //     0xefcaec: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefcaf0: LoadField: r3 = r0->field_1f
    //     0xefcaf0: ldur            w3, [x0, #0x1f]
    // 0xefcaf4: DecompressPointer r3
    //     0xefcaf4: add             x3, x3, HEAP, lsl #32
    // 0xefcaf8: stur            x3, [fp, #-0x18]
    // 0xefcafc: r1 = Null
    //     0xefcafc: mov             x1, NULL
    // 0xefcb00: r2 = 4
    //     0xefcb00: movz            x2, #0x4
    // 0xefcb04: r0 = AllocateArray()
    //     0xefcb04: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefcb08: r16 = "[commander] 入耳检测 "
    //     0xefcb08: add             x16, PP, #0x13, lsl #12  ; [pp+0x13378] "[commander] 入耳检测 "
    //     0xefcb0c: ldr             x16, [x16, #0x378]
    // 0xefcb10: StoreField: r0->field_f = r16
    //     0xefcb10: stur            w16, [x0, #0xf]
    // 0xefcb14: ldur            x1, [fp, #-0x10]
    // 0xefcb18: StoreField: r0->field_13 = r1
    //     0xefcb18: stur            w1, [x0, #0x13]
    // 0xefcb1c: str             x0, [SP]
    // 0xefcb20: r0 = _interpolate()
    //     0xefcb20: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefcb24: ldur            x1, [fp, #-0x18]
    // 0xefcb28: mov             x2, x0
    // 0xefcb2c: r0 = i()
    //     0xefcb2c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefcb30: ldur            x0, [fp, #-8]
    // 0xefcb34: LoadField: r1 = r0->field_7
    //     0xefcb34: ldur            w1, [x0, #7]
    // 0xefcb38: DecompressPointer r1
    //     0xefcb38: add             x1, x1, HEAP, lsl #32
    // 0xefcb3c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefcb40: cmp             w1, w16
    // 0xefcb44: b.eq            #0xefcbac
    // 0xefcb48: ldur            x0, [fp, #-0x10]
    // 0xefcb4c: stur            x1, [fp, #-0x18]
    // 0xefcb50: r2 = LoadClassIdInstr(r0)
    //     0xefcb50: ldur            x2, [x0, #-1]
    //     0xefcb54: ubfx            x2, x2, #0xc, #0x14
    // 0xefcb58: r16 = "0"
    //     0xefcb58: ldr             x16, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefcb5c: stp             x16, x0, [SP]
    // 0xefcb60: mov             x0, x2
    // 0xefcb64: mov             lr, x0
    // 0xefcb68: ldr             lr, [x21, lr, lsl #3]
    // 0xefcb6c: blr             lr
    // 0xefcb70: ldur            x1, [fp, #-0x18]
    // 0xefcb74: r2 = LoadClassIdInstr(r1)
    //     0xefcb74: ldur            x2, [x1, #-1]
    //     0xefcb78: ubfx            x2, x2, #0xc, #0x14
    // 0xefcb7c: mov             x16, x0
    // 0xefcb80: mov             x0, x2
    // 0xefcb84: mov             x2, x16
    // 0xefcb88: r0 = GDT[cid_x0 + -0xeb4]()
    //     0xefcb88: sub             lr, x0, #0xeb4
    //     0xefcb8c: ldr             lr, [x21, lr, lsl #3]
    //     0xefcb90: blr             lr
    // 0xefcb94: r0 = Null
    //     0xefcb94: mov             x0, NULL
    // 0xefcb98: LeaveFrame
    //     0xefcb98: mov             SP, fp
    //     0xefcb9c: ldp             fp, lr, [SP], #0x10
    // 0xefcba0: ret
    //     0xefcba0: ret             
    // 0xefcba4: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefcba4: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefcba8: b               #0xefcad4
    // 0xefcbac: r9 = receiveHandler
    //     0xefcbac: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefcbb0: ldr             x9, [x9, #0x4a8]
    // 0xefcbb4: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefcbb4: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
  _ _handleTouchControl(/* No info */) {
    // ** addr: 0xefcbb8, size: 0x104
    // 0xefcbb8: EnterFrame
    //     0xefcbb8: stp             fp, lr, [SP, #-0x10]!
    //     0xefcbbc: mov             fp, SP
    // 0xefcbc0: AllocStack(0x28)
    //     0xefcbc0: sub             SP, SP, #0x28
    // 0xefcbc4: SetupParameters(RsCommonReceiver this /* r1 => r1, fp-0x8 */, dynamic _ /* r2 => r2, fp-0x10 */)
    //     0xefcbc4: stur            x1, [fp, #-8]
    //     0xefcbc8: stur            x2, [fp, #-0x10]
    // 0xefcbcc: CheckStackOverflow
    //     0xefcbcc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefcbd0: cmp             SP, x16
    //     0xefcbd4: b.ls            #0xefcca8
    // 0xefcbd8: r0 = LoadStaticField(0x804)
    //     0xefcbd8: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefcbdc: ldr             x0, [x0, #0x1008]
    // 0xefcbe0: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefcbe4: cmp             w0, w16
    // 0xefcbe8: b.ne            #0xefcbf4
    // 0xefcbec: r2 = rsbt
    //     0xefcbec: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefcbf0: r0 = InitLateFinalStaticField()
    //     0xefcbf0: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefcbf4: LoadField: r3 = r0->field_1f
    //     0xefcbf4: ldur            w3, [x0, #0x1f]
    // 0xefcbf8: DecompressPointer r3
    //     0xefcbf8: add             x3, x3, HEAP, lsl #32
    // 0xefcbfc: stur            x3, [fp, #-0x18]
    // 0xefcc00: r1 = Null
    //     0xefcc00: mov             x1, NULL
    // 0xefcc04: r2 = 4
    //     0xefcc04: movz            x2, #0x4
    // 0xefcc08: r0 = AllocateArray()
    //     0xefcc08: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefcc0c: r16 = "[commander] 触控功能 "
    //     0xefcc0c: add             x16, PP, #0x13, lsl #12  ; [pp+0x13388] "[commander] 触控功能 "
    //     0xefcc10: ldr             x16, [x16, #0x388]
    // 0xefcc14: StoreField: r0->field_f = r16
    //     0xefcc14: stur            w16, [x0, #0xf]
    // 0xefcc18: ldur            x1, [fp, #-0x10]
    // 0xefcc1c: StoreField: r0->field_13 = r1
    //     0xefcc1c: stur            w1, [x0, #0x13]
    // 0xefcc20: str             x0, [SP]
    // 0xefcc24: r0 = _interpolate()
    //     0xefcc24: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefcc28: ldur            x1, [fp, #-0x18]
    // 0xefcc2c: mov             x2, x0
    // 0xefcc30: r0 = i()
    //     0xefcc30: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefcc34: ldur            x0, [fp, #-8]
    // 0xefcc38: LoadField: r1 = r0->field_7
    //     0xefcc38: ldur            w1, [x0, #7]
    // 0xefcc3c: DecompressPointer r1
    //     0xefcc3c: add             x1, x1, HEAP, lsl #32
    // 0xefcc40: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefcc44: cmp             w1, w16
    // 0xefcc48: b.eq            #0xefccb0
    // 0xefcc4c: ldur            x0, [fp, #-0x10]
    // 0xefcc50: stur            x1, [fp, #-0x18]
    // 0xefcc54: r2 = LoadClassIdInstr(r0)
    //     0xefcc54: ldur            x2, [x0, #-1]
    //     0xefcc58: ubfx            x2, x2, #0xc, #0x14
    // 0xefcc5c: r16 = "0"
    //     0xefcc5c: ldr             x16, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xefcc60: stp             x16, x0, [SP]
    // 0xefcc64: mov             x0, x2
    // 0xefcc68: mov             lr, x0
    // 0xefcc6c: ldr             lr, [x21, lr, lsl #3]
    // 0xefcc70: blr             lr
    // 0xefcc74: ldur            x1, [fp, #-0x18]
    // 0xefcc78: r2 = LoadClassIdInstr(r1)
    //     0xefcc78: ldur            x2, [x1, #-1]
    //     0xefcc7c: ubfx            x2, x2, #0xc, #0x14
    // 0xefcc80: mov             x16, x0
    // 0xefcc84: mov             x0, x2
    // 0xefcc88: mov             x2, x16
    // 0xefcc8c: r0 = GDT[cid_x0 + -0xec2]()
    //     0xefcc8c: sub             lr, x0, #0xec2
    //     0xefcc90: ldr             lr, [x21, lr, lsl #3]
    //     0xefcc94: blr             lr
    // 0xefcc98: r0 = Null
    //     0xefcc98: mov             x0, NULL
    // 0xefcc9c: LeaveFrame
    //     0xefcc9c: mov             SP, fp
    //     0xefcca0: ldp             fp, lr, [SP], #0x10
    // 0xefcca4: ret
    //     0xefcca4: ret             
    // 0xefcca8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefcca8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefccac: b               #0xefcbd8
    // 0xefccb0: r9 = receiveHandler
    //     0xefccb0: add             x9, PP, #0x12, lsl #12  ; [pp+0x124a8] Field <RReceiver.receiveHandler>: late (offset: 0x8)
    //     0xefccb4: ldr             x9, [x9, #0x4a8]
    // 0xefccb8: r0 = LateInitializationErrorSharedWithoutFPURegs()
    //     0xefccb8: bl              #0xf1f5e0  ; LateInitializationErrorSharedWithoutFPURegsStub
  }
}
