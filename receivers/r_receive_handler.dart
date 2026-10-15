// lib: , url: package:roselink_bluetooth/commander/receiver/r_receive_handler.dart

// class id: 1050399, size: 0x8
class :: {
}

// class id: 416, size: 0x14, field offset: 0x8
//   const constructor, 
class EqPreset extends Object {

  Map<String, dynamic> toJson(EqPreset) {
    // ** addr: 0x6d88b8, size: 0x48
    // 0x6d88b8: EnterFrame
    //     0x6d88b8: stp             fp, lr, [SP, #-0x10]!
    //     0x6d88bc: mov             fp, SP
    // 0x6d88c0: CheckStackOverflow
    //     0x6d88c0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d88c4: cmp             SP, x16
    //     0x6d88c8: b.ls            #0x6d88e0
    // 0x6d88cc: ldr             x1, [fp, #0x10]
    // 0x6d88d0: r0 = toJson()
    //     0x6d88d0: bl              #0x6d88e8  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqPreset::toJson
    // 0x6d88d4: LeaveFrame
    //     0x6d88d4: mov             SP, fp
    //     0x6d88d8: ldp             fp, lr, [SP], #0x10
    // 0x6d88dc: ret
    //     0x6d88dc: ret             
    // 0x6d88e0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d88e0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d88e4: b               #0x6d88cc
  }
  Map<String, dynamic> toJson(EqPreset) {
    // ** addr: 0x6d88e8, size: 0x80
    // 0x6d88e8: EnterFrame
    //     0x6d88e8: stp             fp, lr, [SP, #-0x10]!
    //     0x6d88ec: mov             fp, SP
    // 0x6d88f0: AllocStack(0x18)
    //     0x6d88f0: sub             SP, SP, #0x18
    // 0x6d88f4: SetupParameters(EqPreset this /* r1 => r0, fp-0x8 */)
    //     0x6d88f4: mov             x0, x1
    //     0x6d88f8: stur            x1, [fp, #-8]
    // 0x6d88fc: CheckStackOverflow
    //     0x6d88fc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8900: cmp             SP, x16
    //     0x6d8904: b.ls            #0x6d8960
    // 0x6d8908: r1 = Null
    //     0x6d8908: mov             x1, NULL
    // 0x6d890c: r2 = 8
    //     0x6d890c: movz            x2, #0x8
    // 0x6d8910: r0 = AllocateArray()
    //     0x6d8910: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0x6d8914: r16 = "name"
    //     0x6d8914: ldr             x16, [PP, #0x5fa8]  ; [pp+0x5fa8] "name"
    // 0x6d8918: StoreField: r0->field_f = r16
    //     0x6d8918: stur            w16, [x0, #0xf]
    // 0x6d891c: ldur            x1, [fp, #-8]
    // 0x6d8920: LoadField: r2 = r1->field_b
    //     0x6d8920: ldur            w2, [x1, #0xb]
    // 0x6d8924: DecompressPointer r2
    //     0x6d8924: add             x2, x2, HEAP, lsl #32
    // 0x6d8928: StoreField: r0->field_13 = r2
    //     0x6d8928: stur            w2, [x0, #0x13]
    // 0x6d892c: r16 = "data"
    //     0x6d892c: ldr             x16, [PP, #0xcb8]  ; [pp+0xcb8] "data"
    // 0x6d8930: ArrayStore: r0[0] = r16  ; List_4
    //     0x6d8930: stur            w16, [x0, #0x17]
    // 0x6d8934: LoadField: r2 = r1->field_f
    //     0x6d8934: ldur            w2, [x1, #0xf]
    // 0x6d8938: DecompressPointer r2
    //     0x6d8938: add             x2, x2, HEAP, lsl #32
    // 0x6d893c: LoadField: r1 = r2->field_7
    //     0x6d893c: ldur            w1, [x2, #7]
    // 0x6d8940: DecompressPointer r1
    //     0x6d8940: add             x1, x1, HEAP, lsl #32
    // 0x6d8944: StoreField: r0->field_1b = r1
    //     0x6d8944: stur            w1, [x0, #0x1b]
    // 0x6d8948: r16 = <String, dynamic>
    //     0x6d8948: ldr             x16, [PP, #0x14c8]  ; [pp+0x14c8] TypeArguments: <String, dynamic>
    // 0x6d894c: stp             x0, x16, [SP]
    // 0x6d8950: r0 = Map._fromLiteral()
    //     0x6d8950: bl              #0x5f9f50  ; [dart:core] Map::Map._fromLiteral
    // 0x6d8954: LeaveFrame
    //     0x6d8954: mov             SP, fp
    //     0x6d8958: ldp             fp, lr, [SP], #0x10
    // 0x6d895c: ret
    //     0x6d895c: ret             
    // 0x6d8960: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8960: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8964: b               #0x6d8908
  }
  factory _ EqPreset.create(/* No info */) {
    // ** addr: 0x6d8ac4, size: 0x60
    // 0x6d8ac4: EnterFrame
    //     0x6d8ac4: stp             fp, lr, [SP, #-0x10]!
    //     0x6d8ac8: mov             fp, SP
    // 0x6d8acc: AllocStack(0x18)
    //     0x6d8acc: sub             SP, SP, #0x18
    // 0x6d8ad0: SetupParameters(dynamic _ /* r2 => r0, fp-0x8 */, dynamic _ /* r3 => r3, fp-0x10 */)
    //     0x6d8ad0: mov             x0, x2
    //     0x6d8ad4: stur            x2, [fp, #-8]
    //     0x6d8ad8: stur            x3, [fp, #-0x10]
    // 0x6d8adc: CheckStackOverflow
    //     0x6d8adc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8ae0: cmp             SP, x16
    //     0x6d8ae4: b.ls            #0x6d8b1c
    // 0x6d8ae8: mov             x1, x0
    // 0x6d8aec: r0 = format()
    //     0x6d8aec: bl              #0x6d8b30  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::format
    // 0x6d8af0: stur            x0, [fp, #-0x18]
    // 0x6d8af4: r0 = EqPreset()
    //     0x6d8af4: bl              #0x6d8b24  ; AllocateEqPresetStub -> EqPreset (size=0x14)
    // 0x6d8af8: ldur            x1, [fp, #-0x18]
    // 0x6d8afc: StoreField: r0->field_7 = r1
    //     0x6d8afc: stur            w1, [x0, #7]
    // 0x6d8b00: ldur            x1, [fp, #-0x10]
    // 0x6d8b04: StoreField: r0->field_b = r1
    //     0x6d8b04: stur            w1, [x0, #0xb]
    // 0x6d8b08: ldur            x1, [fp, #-8]
    // 0x6d8b0c: StoreField: r0->field_f = r1
    //     0x6d8b0c: stur            w1, [x0, #0xf]
    // 0x6d8b10: LeaveFrame
    //     0x6d8b10: mov             SP, fp
    //     0x6d8b14: ldp             fp, lr, [SP], #0x10
    // 0x6d8b18: ret
    //     0x6d8b18: ret             
    // 0x6d8b1c: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8b1c: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8b20: b               #0x6d8ae8
  }
  factory _ EqPreset.fromJson(/* No info */) {
    // ** addr: 0x792608, size: 0x148
    // 0x792608: EnterFrame
    //     0x792608: stp             fp, lr, [SP, #-0x10]!
    //     0x79260c: mov             fp, SP
    // 0x792610: AllocStack(0x18)
    //     0x792610: sub             SP, SP, #0x18
    // 0x792614: SetupParameters(dynamic _ /* r2 => r0, fp-0x8 */)
    //     0x792614: mov             x0, x2
    //     0x792618: stur            x2, [fp, #-8]
    // 0x79261c: CheckStackOverflow
    //     0x79261c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x792620: cmp             SP, x16
    //     0x792624: b.ls            #0x792748
    // 0x792628: mov             x1, x0
    // 0x79262c: r2 = "data"
    //     0x79262c: ldr             x2, [PP, #0xcb8]  ; [pp+0xcb8] "data"
    // 0x792630: r0 = _getValueOrData()
    //     0x792630: bl              #0xf17d64  ; [dart:_compact_hash] __Map&_HashVMBase&MapMixin&_HashBase&_OperatorEqualsAndHashCode&_LinkedHashMapMixin::_getValueOrData
    // 0x792634: ldur            x3, [fp, #-8]
    // 0x792638: LoadField: r1 = r3->field_f
    //     0x792638: ldur            w1, [x3, #0xf]
    // 0x79263c: DecompressPointer r1
    //     0x79263c: add             x1, x1, HEAP, lsl #32
    // 0x792640: cmp             w1, w0
    // 0x792644: b.ne            #0x792650
    // 0x792648: r4 = Null
    //     0x792648: mov             x4, NULL
    // 0x79264c: b               #0x792654
    // 0x792650: mov             x4, x0
    // 0x792654: mov             x0, x4
    // 0x792658: stur            x4, [fp, #-0x10]
    // 0x79265c: r2 = Null
    //     0x79265c: mov             x2, NULL
    // 0x792660: r1 = Null
    //     0x792660: mov             x1, NULL
    // 0x792664: r4 = 60
    //     0x792664: movz            x4, #0x3c
    // 0x792668: branchIfSmi(r0, 0x792674)
    //     0x792668: tbz             w0, #0, #0x792674
    // 0x79266c: r4 = LoadClassIdInstr(r0)
    //     0x79266c: ldur            x4, [x0, #-1]
    //     0x792670: ubfx            x4, x4, #0xc, #0x14
    // 0x792674: sub             x4, x4, #0x5a
    // 0x792678: cmp             x4, #2
    // 0x79267c: b.ls            #0x792690
    // 0x792680: r8 = List
    //     0x792680: ldr             x8, [PP, #0x2e90]  ; [pp+0x2e90] Type: List
    // 0x792684: r3 = Null
    //     0x792684: add             x3, PP, #0x10, lsl #12  ; [pp+0x104d0] Null
    //     0x792688: ldr             x3, [x3, #0x4d0]
    // 0x79268c: r0 = List()
    //     0x79268c: bl              #0xf32534  ; IsType_List_Stub
    // 0x792690: ldur            x2, [fp, #-0x10]
    // 0x792694: r1 = Null
    //     0x792694: mov             x1, NULL
    // 0x792698: r0 = EqData.fromJson()
    //     0x792698: bl              #0x792750  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::EqData.fromJson
    // 0x79269c: mov             x1, x0
    // 0x7926a0: stur            x0, [fp, #-0x10]
    // 0x7926a4: r0 = format()
    //     0x7926a4: bl              #0x6d8b30  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::format
    // 0x7926a8: ldur            x1, [fp, #-8]
    // 0x7926ac: r2 = "name"
    //     0x7926ac: ldr             x2, [PP, #0x5fa8]  ; [pp+0x5fa8] "name"
    // 0x7926b0: stur            x0, [fp, #-0x18]
    // 0x7926b4: r0 = _getValueOrData()
    //     0x7926b4: bl              #0xf17d64  ; [dart:_compact_hash] __Map&_HashVMBase&MapMixin&_HashBase&_OperatorEqualsAndHashCode&_LinkedHashMapMixin::_getValueOrData
    // 0x7926b8: mov             x1, x0
    // 0x7926bc: ldur            x0, [fp, #-8]
    // 0x7926c0: LoadField: r2 = r0->field_f
    //     0x7926c0: ldur            w2, [x0, #0xf]
    // 0x7926c4: DecompressPointer r2
    //     0x7926c4: add             x2, x2, HEAP, lsl #32
    // 0x7926c8: cmp             w2, w1
    // 0x7926cc: b.ne            #0x7926d8
    // 0x7926d0: r5 = Null
    //     0x7926d0: mov             x5, NULL
    // 0x7926d4: b               #0x7926dc
    // 0x7926d8: mov             x5, x1
    // 0x7926dc: ldur            x4, [fp, #-0x10]
    // 0x7926e0: ldur            x3, [fp, #-0x18]
    // 0x7926e4: mov             x0, x5
    // 0x7926e8: stur            x5, [fp, #-8]
    // 0x7926ec: r2 = Null
    //     0x7926ec: mov             x2, NULL
    // 0x7926f0: r1 = Null
    //     0x7926f0: mov             x1, NULL
    // 0x7926f4: r4 = 60
    //     0x7926f4: movz            x4, #0x3c
    // 0x7926f8: branchIfSmi(r0, 0x792704)
    //     0x7926f8: tbz             w0, #0, #0x792704
    // 0x7926fc: r4 = LoadClassIdInstr(r0)
    //     0x7926fc: ldur            x4, [x0, #-1]
    //     0x792700: ubfx            x4, x4, #0xc, #0x14
    // 0x792704: sub             x4, x4, #0x5e
    // 0x792708: cmp             x4, #1
    // 0x79270c: b.ls            #0x792720
    // 0x792710: r8 = String
    //     0x792710: ldr             x8, [PP, #0x598]  ; [pp+0x598] Type: String
    // 0x792714: r3 = Null
    //     0x792714: add             x3, PP, #0x10, lsl #12  ; [pp+0x104e0] Null
    //     0x792718: ldr             x3, [x3, #0x4e0]
    // 0x79271c: r0 = String()
    //     0x79271c: bl              #0xf30e18  ; IsType_String_Stub
    // 0x792720: r0 = EqPreset()
    //     0x792720: bl              #0x6d8b24  ; AllocateEqPresetStub -> EqPreset (size=0x14)
    // 0x792724: ldur            x1, [fp, #-0x18]
    // 0x792728: StoreField: r0->field_7 = r1
    //     0x792728: stur            w1, [x0, #7]
    // 0x79272c: ldur            x1, [fp, #-8]
    // 0x792730: StoreField: r0->field_b = r1
    //     0x792730: stur            w1, [x0, #0xb]
    // 0x792734: ldur            x1, [fp, #-0x10]
    // 0x792738: StoreField: r0->field_f = r1
    //     0x792738: stur            w1, [x0, #0xf]
    // 0x79273c: LeaveFrame
    //     0x79273c: mov             SP, fp
    //     0x792740: ldp             fp, lr, [SP], #0x10
    // 0x792744: ret
    //     0x792744: ret             
    // 0x792748: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x792748: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x79274c: b               #0x792628
  }
  _ copyWith(/* No info */) {
    // ** addr: 0xb3160c, size: 0x130
    // 0xb3160c: EnterFrame
    //     0xb3160c: stp             fp, lr, [SP, #-0x10]!
    //     0xb31610: mov             fp, SP
    // 0xb31614: AllocStack(0x20)
    //     0xb31614: sub             SP, SP, #0x20
    // 0xb31618: SetupParameters(EqPreset this /* r1 => r0, fp-0x18 */, {dynamic data = Null /* r3 */, dynamic name = Null /* r2, fp-0x10 */})
    //     0xb31618: mov             x0, x1
    //     0xb3161c: stur            x1, [fp, #-0x18]
    //     0xb31620: ldur            w1, [x4, #0x13]
    //     0xb31624: ldur            w2, [x4, #0x1f]
    //     0xb31628: add             x2, x2, HEAP, lsl #32
    //     0xb3162c: ldr             x16, [PP, #0xcb8]  ; [pp+0xcb8] "data"
    //     0xb31630: cmp             w2, w16
    //     0xb31634: b.ne            #0xb31658
    //     0xb31638: ldur            w2, [x4, #0x23]
    //     0xb3163c: add             x2, x2, HEAP, lsl #32
    //     0xb31640: sub             w3, w1, w2
    //     0xb31644: add             x2, fp, w3, sxtw #2
    //     0xb31648: ldr             x2, [x2, #8]
    //     0xb3164c: mov             x3, x2
    //     0xb31650: movz            x2, #0x1
    //     0xb31654: b               #0xb31660
    //     0xb31658: mov             x3, NULL
    //     0xb3165c: movz            x2, #0
    //     0xb31660: lsl             x5, x2, #1
    //     0xb31664: lsl             w2, w5, #1
    //     0xb31668: add             w5, w2, #8
    //     0xb3166c: add             x16, x4, w5, sxtw #1
    //     0xb31670: ldur            w6, [x16, #0xf]
    //     0xb31674: add             x6, x6, HEAP, lsl #32
    //     0xb31678: ldr             x16, [PP, #0x5fa8]  ; [pp+0x5fa8] "name"
    //     0xb3167c: cmp             w6, w16
    //     0xb31680: b.ne            #0xb316a8
    //     0xb31684: add             w5, w2, #0xa
    //     0xb31688: add             x16, x4, w5, sxtw #1
    //     0xb3168c: ldur            w2, [x16, #0xf]
    //     0xb31690: add             x2, x2, HEAP, lsl #32
    //     0xb31694: sub             w4, w1, w2
    //     0xb31698: add             x1, fp, w4, sxtw #2
    //     0xb3169c: ldr             x1, [x1, #8]
    //     0xb316a0: mov             x2, x1
    //     0xb316a4: b               #0xb316ac
    //     0xb316a8: mov             x2, NULL
    //     0xb316ac: stur            x2, [fp, #-0x10]
    // 0xb316b0: CheckStackOverflow
    //     0xb316b0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xb316b4: cmp             SP, x16
    //     0xb316b8: b.ls            #0xb31734
    // 0xb316bc: cmp             w3, NULL
    // 0xb316c0: b.ne            #0xb316d0
    // 0xb316c4: LoadField: r1 = r0->field_f
    //     0xb316c4: ldur            w1, [x0, #0xf]
    // 0xb316c8: DecompressPointer r1
    //     0xb316c8: add             x1, x1, HEAP, lsl #32
    // 0xb316cc: mov             x3, x1
    // 0xb316d0: mov             x1, x3
    // 0xb316d4: stur            x3, [fp, #-8]
    // 0xb316d8: r0 = format()
    //     0xb316d8: bl              #0x6d8b30  ; [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::format
    // 0xb316dc: mov             x1, x0
    // 0xb316e0: ldur            x0, [fp, #-0x10]
    // 0xb316e4: stur            x1, [fp, #-0x20]
    // 0xb316e8: cmp             w0, NULL
    // 0xb316ec: b.ne            #0xb31700
    // 0xb316f0: ldur            x0, [fp, #-0x18]
    // 0xb316f4: LoadField: r2 = r0->field_b
    //     0xb316f4: ldur            w2, [x0, #0xb]
    // 0xb316f8: DecompressPointer r2
    //     0xb316f8: add             x2, x2, HEAP, lsl #32
    // 0xb316fc: b               #0xb31704
    // 0xb31700: mov             x2, x0
    // 0xb31704: ldur            x0, [fp, #-8]
    // 0xb31708: stur            x2, [fp, #-0x10]
    // 0xb3170c: r0 = EqPreset()
    //     0xb3170c: bl              #0x6d8b24  ; AllocateEqPresetStub -> EqPreset (size=0x14)
    // 0xb31710: ldur            x1, [fp, #-0x20]
    // 0xb31714: StoreField: r0->field_7 = r1
    //     0xb31714: stur            w1, [x0, #7]
    // 0xb31718: ldur            x1, [fp, #-0x10]
    // 0xb3171c: StoreField: r0->field_b = r1
    //     0xb3171c: stur            w1, [x0, #0xb]
    // 0xb31720: ldur            x1, [fp, #-8]
    // 0xb31724: StoreField: r0->field_f = r1
    //     0xb31724: stur            w1, [x0, #0xf]
    // 0xb31728: LeaveFrame
    //     0xb31728: mov             SP, fp
    //     0xb3172c: ldp             fp, lr, [SP], #0x10
    // 0xb31730: ret
    //     0xb31730: ret             
    // 0xb31734: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xb31734: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xb31738: b               #0xb316bc
  }
}

// class id: 417, size: 0xc, field offset: 0x8
class EqData extends Object {

  get _ format(/* No info */) {
    // ** addr: 0x6d8b30, size: 0x19c
    // 0x6d8b30: EnterFrame
    //     0x6d8b30: stp             fp, lr, [SP, #-0x10]!
    //     0x6d8b34: mov             fp, SP
    // 0x6d8b38: AllocStack(0x30)
    //     0x6d8b38: sub             SP, SP, #0x30
    // 0x6d8b3c: SetupParameters(EqData this /* r1 => r1, fp-0x8 */)
    //     0x6d8b3c: stur            x1, [fp, #-8]
    // 0x6d8b40: CheckStackOverflow
    //     0x6d8b40: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8b44: cmp             SP, x16
    //     0x6d8b48: b.ls            #0x6d8c90
    // 0x6d8b4c: r0 = StringBuffer()
    //     0x6d8b4c: bl              #0x608a18  ; AllocateStringBufferStub -> StringBuffer (size=0x38)
    // 0x6d8b50: mov             x1, x0
    // 0x6d8b54: stur            x0, [fp, #-0x10]
    // 0x6d8b58: r4 = const [0, 0x1, 0, 0x1, null]
    //     0x6d8b58: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0x6d8b5c: r0 = StringBuffer()
    //     0x6d8b5c: bl              #0x608220  ; [dart:core] StringBuffer::StringBuffer
    // 0x6d8b60: ldur            x0, [fp, #-8]
    // 0x6d8b64: LoadField: r3 = r0->field_7
    //     0x6d8b64: ldur            w3, [x0, #7]
    // 0x6d8b68: DecompressPointer r3
    //     0x6d8b68: add             x3, x3, HEAP, lsl #32
    // 0x6d8b6c: stur            x3, [fp, #-0x28]
    // 0x6d8b70: LoadField: r0 = r3->field_b
    //     0x6d8b70: ldur            w0, [x3, #0xb]
    // 0x6d8b74: r4 = LoadInt32Instr(r0)
    //     0x6d8b74: sbfx            x4, x0, #1, #0x1f
    // 0x6d8b78: stur            x4, [fp, #-0x20]
    // 0x6d8b7c: r0 = 0
    //     0x6d8b7c: movz            x0, #0
    // 0x6d8b80: CheckStackOverflow
    //     0x6d8b80: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8b84: cmp             SP, x16
    //     0x6d8b88: b.ls            #0x6d8c98
    // 0x6d8b8c: cmp             x0, x4
    // 0x6d8b90: b.ge            #0x6d8c78
    // 0x6d8b94: ArrayLoad: r1 = r3[r0]  ; Unknown_4
    //     0x6d8b94: add             x16, x3, x0, lsl #2
    //     0x6d8b98: ldur            w1, [x16, #0xf]
    // 0x6d8b9c: DecompressPointer r1
    //     0x6d8b9c: add             x1, x1, HEAP, lsl #32
    // 0x6d8ba0: add             x5, x0, #1
    // 0x6d8ba4: stur            x5, [fp, #-0x18]
    // 0x6d8ba8: LoadField: d0 = r1->field_7
    //     0x6d8ba8: ldur            d0, [x1, #7]
    // 0x6d8bac: fcmp            d0, d0
    // 0x6d8bb0: b.vs            #0x6d8ca0
    // 0x6d8bb4: fcvtzs          x0, d0
    // 0x6d8bb8: asr             x16, x0, #0x1e
    // 0x6d8bbc: cmp             x16, x0, asr #63
    // 0x6d8bc0: b.ne            #0x6d8ca0
    // 0x6d8bc4: lsl             x0, x0, #1
    // 0x6d8bc8: r1 = LoadInt32Instr(r0)
    //     0x6d8bc8: sbfx            x1, x0, #1, #0x1f
    //     0x6d8bcc: tbz             w0, #0, #0x6d8bd4
    //     0x6d8bd0: ldur            x1, [x0, #7]
    // 0x6d8bd4: tbnz            x1, #0x3f, #0x6d8be0
    // 0x6d8bd8: r0 = false
    //     0x6d8bd8: add             x0, NULL, #0x30  ; false
    // 0x6d8bdc: b               #0x6d8be4
    // 0x6d8be0: r0 = true
    //     0x6d8be0: add             x0, NULL, #0x20  ; true
    // 0x6d8be4: tbz             x1, #0x3f, #0x6d8bf0
    // 0x6d8be8: neg             x2, x1
    // 0x6d8bec: mov             x1, x2
    // 0x6d8bf0: ubfx            x1, x1, #0, #0x20
    // 0x6d8bf4: and             w2, w1, #0x7f
    // 0x6d8bf8: tst             x0, #0x10
    // 0x6d8bfc: cset            x1, eq
    // 0x6d8c00: lsl             x1, x1, #1
    // 0x6d8c04: r0 = LoadInt32Instr(r1)
    //     0x6d8c04: sbfx            x0, x1, #1, #0x1f
    // 0x6d8c08: lsl             x1, x0, #7
    // 0x6d8c0c: ubfx            x2, x2, #0, #0x20
    // 0x6d8c10: orr             x0, x1, x2
    // 0x6d8c14: lsl             x1, x0, #1
    // 0x6d8c18: r2 = 16
    //     0x6d8c18: movz            x2, #0x10
    // 0x6d8c1c: r0 = _toPow2String()
    //     0x6d8c1c: bl              #0x6511a4  ; [dart:core] _IntegerImplementation::_toPow2String
    // 0x6d8c20: mov             x1, x0
    // 0x6d8c24: r2 = 2
    //     0x6d8c24: movz            x2, #0x2
    // 0x6d8c28: r3 = "0"
    //     0x6d8c28: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0x6d8c2c: r0 = padLeft()
    //     0x6d8c2c: bl              #0xf1b814  ; [dart:core] _OneByteString::padLeft
    // 0x6d8c30: r1 = LoadClassIdInstr(r0)
    //     0x6d8c30: ldur            x1, [x0, #-1]
    //     0x6d8c34: ubfx            x1, x1, #0xc, #0x14
    // 0x6d8c38: str             x0, [SP]
    // 0x6d8c3c: mov             x0, x1
    // 0x6d8c40: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0x6d8c40: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0x6d8c44: r0 = GDT[cid_x0 + 0x28cf]()
    //     0x6d8c44: movz            x17, #0x28cf
    //     0x6d8c48: add             lr, x0, x17
    //     0x6d8c4c: ldr             lr, [x21, lr, lsl #3]
    //     0x6d8c50: blr             lr
    // 0x6d8c54: LoadField: r1 = r0->field_7
    //     0x6d8c54: ldur            w1, [x0, #7]
    // 0x6d8c58: cbz             w1, #0x6d8c68
    // 0x6d8c5c: ldur            x1, [fp, #-0x10]
    // 0x6d8c60: mov             x2, x0
    // 0x6d8c64: r0 = _writeString()
    //     0x6d8c64: bl              #0x608450  ; [dart:core] StringBuffer::_writeString
    // 0x6d8c68: ldur            x0, [fp, #-0x18]
    // 0x6d8c6c: ldur            x3, [fp, #-0x28]
    // 0x6d8c70: ldur            x4, [fp, #-0x20]
    // 0x6d8c74: b               #0x6d8b80
    // 0x6d8c78: ldur            x16, [fp, #-0x10]
    // 0x6d8c7c: str             x16, [SP]
    // 0x6d8c80: r0 = toString()
    //     0x6d8c80: bl              #0xd7398c  ; [dart:core] StringBuffer::toString
    // 0x6d8c84: LeaveFrame
    //     0x6d8c84: mov             SP, fp
    //     0x6d8c88: ldp             fp, lr, [SP], #0x10
    // 0x6d8c8c: ret
    //     0x6d8c8c: ret             
    // 0x6d8c90: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8c90: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8c94: b               #0x6d8b4c
    // 0x6d8c98: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8c98: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8c9c: b               #0x6d8b8c
    // 0x6d8ca0: SaveReg d0
    //     0x6d8ca0: str             q0, [SP, #-0x10]!
    // 0x6d8ca4: stp             x4, x5, [SP, #-0x10]!
    // 0x6d8ca8: SaveReg r3
    //     0x6d8ca8: str             x3, [SP, #-8]!
    // 0x6d8cac: r0 = 76
    //     0x6d8cac: movz            x0, #0x4c
    // 0x6d8cb0: r30 = DoubleToIntegerStub
    //     0x6d8cb0: ldr             lr, [PP, #0x13b0]  ; [pp+0x13b0] Stub: DoubleToInteger (0x5f1890)
    // 0x6d8cb4: LoadField: r30 = r30->field_7
    //     0x6d8cb4: ldur            lr, [lr, #7]
    // 0x6d8cb8: blr             lr
    // 0x6d8cbc: RestoreReg r3
    //     0x6d8cbc: ldr             x3, [SP], #8
    // 0x6d8cc0: ldp             x4, x5, [SP], #0x10
    // 0x6d8cc4: RestoreReg d0
    //     0x6d8cc4: ldr             q0, [SP], #0x10
    // 0x6d8cc8: b               #0x6d8bc8
  }
  double [](EqData, int) {
    // ** addr: 0x6d8e2c, size: 0xa0
    // 0x6d8e2c: EnterFrame
    //     0x6d8e2c: stp             fp, lr, [SP, #-0x10]!
    //     0x6d8e30: mov             fp, SP
    // 0x6d8e34: ldr             x0, [fp, #0x10]
    // 0x6d8e38: r2 = Null
    //     0x6d8e38: mov             x2, NULL
    // 0x6d8e3c: r1 = Null
    //     0x6d8e3c: mov             x1, NULL
    // 0x6d8e40: branchIfSmi(r0, 0x6d8e68)
    //     0x6d8e40: tbz             w0, #0, #0x6d8e68
    // 0x6d8e44: r4 = LoadClassIdInstr(r0)
    //     0x6d8e44: ldur            x4, [x0, #-1]
    //     0x6d8e48: ubfx            x4, x4, #0xc, #0x14
    // 0x6d8e4c: sub             x4, x4, #0x3c
    // 0x6d8e50: cmp             x4, #1
    // 0x6d8e54: b.ls            #0x6d8e68
    // 0x6d8e58: r8 = int
    //     0x6d8e58: ldr             x8, [PP, #0xd60]  ; [pp+0xd60] Type: int
    // 0x6d8e5c: r3 = Null
    //     0x6d8e5c: add             x3, PP, #0x13, lsl #12  ; [pp+0x13fb8] Null
    //     0x6d8e60: ldr             x3, [x3, #0xfb8]
    // 0x6d8e64: r0 = int()
    //     0x6d8e64: bl              #0xf31478  ; IsType_int_Stub
    // 0x6d8e68: ldr             x2, [fp, #0x18]
    // 0x6d8e6c: LoadField: r3 = r2->field_7
    //     0x6d8e6c: ldur            w3, [x2, #7]
    // 0x6d8e70: DecompressPointer r3
    //     0x6d8e70: add             x3, x3, HEAP, lsl #32
    // 0x6d8e74: LoadField: r2 = r3->field_b
    //     0x6d8e74: ldur            w2, [x3, #0xb]
    // 0x6d8e78: ldr             x4, [fp, #0x10]
    // 0x6d8e7c: r5 = LoadInt32Instr(r4)
    //     0x6d8e7c: sbfx            x5, x4, #1, #0x1f
    //     0x6d8e80: tbz             w4, #0, #0x6d8e88
    //     0x6d8e84: ldur            x5, [x4, #7]
    // 0x6d8e88: r0 = LoadInt32Instr(r2)
    //     0x6d8e88: sbfx            x0, x2, #1, #0x1f
    // 0x6d8e8c: mov             x1, x5
    // 0x6d8e90: cmp             x1, x0
    // 0x6d8e94: b.hs            #0x6d8eb0
    // 0x6d8e98: ArrayLoad: r0 = r3[r5]  ; Unknown_4
    //     0x6d8e98: add             x16, x3, x5, lsl #2
    //     0x6d8e9c: ldur            w0, [x16, #0xf]
    // 0x6d8ea0: DecompressPointer r0
    //     0x6d8ea0: add             x0, x0, HEAP, lsl #32
    // 0x6d8ea4: LeaveFrame
    //     0x6d8ea4: mov             SP, fp
    //     0x6d8ea8: ldp             fp, lr, [SP], #0x10
    // 0x6d8eac: ret
    //     0x6d8eac: ret             
    // 0x6d8eb0: r0 = RangeErrorSharedWithoutFPURegs()
    //     0x6d8eb0: bl              #0xf1f1f8  ; RangeErrorSharedWithoutFPURegsStub
  }
  factory _ EqData.zero(/* No info */) {
    // ** addr: 0x6d8eb4, size: 0xac
    // 0x6d8eb4: EnterFrame
    //     0x6d8eb4: stp             fp, lr, [SP, #-0x10]!
    //     0x6d8eb8: mov             fp, SP
    // 0x6d8ebc: AllocStack(0x18)
    //     0x6d8ebc: sub             SP, SP, #0x18
    // 0x6d8ec0: CheckStackOverflow
    //     0x6d8ec0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8ec4: cmp             SP, x16
    //     0x6d8ec8: b.ls            #0x6d8f50
    // 0x6d8ecc: r1 = <double>
    //     0x6d8ecc: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x6d8ed0: r2 = 20
    //     0x6d8ed0: movz            x2, #0x14
    // 0x6d8ed4: r0 = AllocateArray()
    //     0x6d8ed4: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0x6d8ed8: r1 = 0
    //     0x6d8ed8: movz            x1, #0
    // 0x6d8edc: CheckStackOverflow
    //     0x6d8edc: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x6d8ee0: cmp             SP, x16
    //     0x6d8ee4: b.ls            #0x6d8f58
    // 0x6d8ee8: cmp             x1, #0xa
    // 0x6d8eec: b.ge            #0x6d8f08
    // 0x6d8ef0: add             x2, x0, x1, lsl #2
    // 0x6d8ef4: r16 = 0.000000
    //     0x6d8ef4: ldr             x16, [PP, #0x49f0]  ; [pp+0x49f0] 0
    // 0x6d8ef8: StoreField: r2->field_f = r16
    //     0x6d8ef8: stur            w16, [x2, #0xf]
    // 0x6d8efc: add             x2, x1, #1
    // 0x6d8f00: mov             x1, x2
    // 0x6d8f04: b               #0x6d8edc
    // 0x6d8f08: r16 = false
    //     0x6d8f08: add             x16, NULL, #0x30  ; false
    // 0x6d8f0c: str             x16, [SP]
    // 0x6d8f10: mov             x2, x0
    // 0x6d8f14: r1 = <double>
    //     0x6d8f14: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x6d8f18: r4 = const [0, 0x3, 0x1, 0x2, growable, 0x2, null]
    //     0x6d8f18: add             x4, PP, #8, lsl #12  ; [pp+0x8e60] List(7) [0, 0x3, 0x1, 0x2, "growable", 0x2, Null]
    //     0x6d8f1c: ldr             x4, [x4, #0xe60]
    // 0x6d8f20: r0 = List.from()
    //     0x6d8f20: bl              #0x670c68  ; [dart:core] List::List.from
    // 0x6d8f24: r16 = <double>
    //     0x6d8f24: ldr             x16, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x6d8f28: stp             x0, x16, [SP]
    // 0x6d8f2c: r4 = const [0x1, 0x1, 0x1, 0x1, null]
    //     0x6d8f2c: ldr             x4, [PP, #0x238]  ; [pp+0x238] List(5) [0x1, 0x1, 0x1, 0x1, Null]
    // 0x6d8f30: r0 = makeFixedListUnmodifiable()
    //     0x6d8f30: bl              #0x6c5914  ; [dart:_internal] ::makeFixedListUnmodifiable
    // 0x6d8f34: stur            x0, [fp, #-8]
    // 0x6d8f38: r0 = EqData()
    //     0x6d8f38: bl              #0x6d8f60  ; AllocateEqDataStub -> EqData (size=0xc)
    // 0x6d8f3c: ldur            x1, [fp, #-8]
    // 0x6d8f40: StoreField: r0->field_7 = r1
    //     0x6d8f40: stur            w1, [x0, #7]
    // 0x6d8f44: LeaveFrame
    //     0x6d8f44: mov             SP, fp
    //     0x6d8f48: ldp             fp, lr, [SP], #0x10
    // 0x6d8f4c: ret
    //     0x6d8f4c: ret             
    // 0x6d8f50: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8f50: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8f54: b               #0x6d8ecc
    // 0x6d8f58: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x6d8f58: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x6d8f5c: b               #0x6d8ee8
  }
  factory _ EqData.fromJson(/* No info */) {
    // ** addr: 0x792750, size: 0xdc
    // 0x792750: EnterFrame
    //     0x792750: stp             fp, lr, [SP, #-0x10]!
    //     0x792754: mov             fp, SP
    // 0x792758: AllocStack(0x20)
    //     0x792758: sub             SP, SP, #0x20
    // 0x79275c: SetupParameters(dynamic _ /* r2 => r0, fp-0x8 */)
    //     0x79275c: mov             x0, x2
    //     0x792760: stur            x2, [fp, #-8]
    // 0x792764: CheckStackOverflow
    //     0x792764: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x792768: cmp             SP, x16
    //     0x79276c: b.ls            #0x792824
    // 0x792770: r1 = Function '<anonymous closure>': static.
    //     0x792770: add             x1, PP, #0x10, lsl #12  ; [pp+0x104f0] AnonymousClosure: static (0x79282c), in [package:roselink_bluetooth/commander/receiver/r_receive_handler.dart] EqData::EqData.fromJson (0x792750)
    //     0x792774: ldr             x1, [x1, #0x4f0]
    // 0x792778: r2 = Null
    //     0x792778: mov             x2, NULL
    // 0x79277c: r0 = AllocateClosure()
    //     0x79277c: bl              #0xf1dea0  ; AllocateClosureStub
    // 0x792780: mov             x1, x0
    // 0x792784: ldur            x0, [fp, #-8]
    // 0x792788: r2 = LoadClassIdInstr(r0)
    //     0x792788: ldur            x2, [x0, #-1]
    //     0x79278c: ubfx            x2, x2, #0xc, #0x14
    // 0x792790: r16 = <double>
    //     0x792790: ldr             x16, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x792794: stp             x0, x16, [SP, #8]
    // 0x792798: str             x1, [SP]
    // 0x79279c: mov             x0, x2
    // 0x7927a0: r4 = const [0x1, 0x2, 0x2, 0x2, null]
    //     0x7927a0: ldr             x4, [PP, #0x40]  ; [pp+0x40] List(5) [0x1, 0x2, 0x2, 0x2, Null]
    // 0x7927a4: r0 = GDT[cid_x0 + 0xbf6f]()
    //     0x7927a4: movz            x17, #0xbf6f
    //     0x7927a8: add             lr, x0, x17
    //     0x7927ac: ldr             lr, [x21, lr, lsl #3]
    //     0x7927b0: blr             lr
    // 0x7927b4: r1 = LoadClassIdInstr(r0)
    //     0x7927b4: ldur            x1, [x0, #-1]
    //     0x7927b8: ubfx            x1, x1, #0xc, #0x14
    // 0x7927bc: mov             x16, x0
    // 0x7927c0: mov             x0, x1
    // 0x7927c4: mov             x1, x16
    // 0x7927c8: r4 = const [0, 0x1, 0, 0x1, null]
    //     0x7927c8: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0x7927cc: r0 = GDT[cid_x0 + 0xd4fa]()
    //     0x7927cc: movz            x17, #0xd4fa
    //     0x7927d0: add             lr, x0, x17
    //     0x7927d4: ldr             lr, [x21, lr, lsl #3]
    //     0x7927d8: blr             lr
    // 0x7927dc: r16 = false
    //     0x7927dc: add             x16, NULL, #0x30  ; false
    // 0x7927e0: str             x16, [SP]
    // 0x7927e4: mov             x2, x0
    // 0x7927e8: r1 = <double>
    //     0x7927e8: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x7927ec: r4 = const [0, 0x3, 0x1, 0x2, growable, 0x2, null]
    //     0x7927ec: add             x4, PP, #8, lsl #12  ; [pp+0x8e60] List(7) [0, 0x3, 0x1, 0x2, "growable", 0x2, Null]
    //     0x7927f0: ldr             x4, [x4, #0xe60]
    // 0x7927f4: r0 = List.from()
    //     0x7927f4: bl              #0x670c68  ; [dart:core] List::List.from
    // 0x7927f8: r16 = <double>
    //     0x7927f8: ldr             x16, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0x7927fc: stp             x0, x16, [SP]
    // 0x792800: r4 = const [0x1, 0x1, 0x1, 0x1, null]
    //     0x792800: ldr             x4, [PP, #0x238]  ; [pp+0x238] List(5) [0x1, 0x1, 0x1, 0x1, Null]
    // 0x792804: r0 = makeFixedListUnmodifiable()
    //     0x792804: bl              #0x6c5914  ; [dart:_internal] ::makeFixedListUnmodifiable
    // 0x792808: stur            x0, [fp, #-8]
    // 0x79280c: r0 = EqData()
    //     0x79280c: bl              #0x6d8f60  ; AllocateEqDataStub -> EqData (size=0xc)
    // 0x792810: ldur            x1, [fp, #-8]
    // 0x792814: StoreField: r0->field_7 = r1
    //     0x792814: stur            w1, [x0, #7]
    // 0x792818: LeaveFrame
    //     0x792818: mov             SP, fp
    //     0x79281c: ldp             fp, lr, [SP], #0x10
    // 0x792820: ret
    //     0x792820: ret             
    // 0x792824: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x792824: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x792828: b               #0x792770
  }
  [closure] static double <anonymous closure>(dynamic, dynamic) {
    // ** addr: 0x79282c, size: 0x88
    // 0x79282c: EnterFrame
    //     0x79282c: stp             fp, lr, [SP, #-0x10]!
    //     0x792830: mov             fp, SP
    // 0x792834: AllocStack(0x8)
    //     0x792834: sub             SP, SP, #8
    // 0x792838: CheckStackOverflow
    //     0x792838: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0x79283c: cmp             SP, x16
    //     0x792840: b.ls            #0x7928ac
    // 0x792844: ldr             x0, [fp, #0x10]
    // 0x792848: r2 = Null
    //     0x792848: mov             x2, NULL
    // 0x79284c: r1 = Null
    //     0x79284c: mov             x1, NULL
    // 0x792850: branchIfSmi(r0, 0x792878)
    //     0x792850: tbz             w0, #0, #0x792878
    // 0x792854: r4 = LoadClassIdInstr(r0)
    //     0x792854: ldur            x4, [x0, #-1]
    //     0x792858: ubfx            x4, x4, #0xc, #0x14
    // 0x79285c: sub             x4, x4, #0x3c
    // 0x792860: cmp             x4, #2
    // 0x792864: b.ls            #0x792878
    // 0x792868: r8 = num
    //     0x792868: ldr             x8, [PP, #0xfd8]  ; [pp+0xfd8] Type: num
    // 0x79286c: r3 = Null
    //     0x79286c: add             x3, PP, #0x10, lsl #12  ; [pp+0x104f8] Null
    //     0x792870: ldr             x3, [x3, #0x4f8]
    // 0x792874: r0 = num()
    //     0x792874: bl              #0xf314a8  ; IsType_num_Stub
    // 0x792878: ldr             x0, [fp, #0x10]
    // 0x79287c: r1 = 60
    //     0x79287c: movz            x1, #0x3c
    // 0x792880: branchIfSmi(r0, 0x79288c)
    //     0x792880: tbz             w0, #0, #0x79288c
    // 0x792884: r1 = LoadClassIdInstr(r0)
    //     0x792884: ldur            x1, [x0, #-1]
    //     0x792888: ubfx            x1, x1, #0xc, #0x14
    // 0x79288c: str             x0, [SP]
    // 0x792890: mov             x0, x1
    // 0x792894: r0 = GDT[cid_x0 + -0xffa]()
    //     0x792894: sub             lr, x0, #0xffa
    //     0x792898: ldr             lr, [x21, lr, lsl #3]
    //     0x79289c: blr             lr
    // 0x7928a0: LeaveFrame
    //     0x7928a0: mov             SP, fp
    //     0x7928a4: ldp             fp, lr, [SP], #0x10
    // 0x7928a8: ret
    //     0x7928a8: ret             
    // 0x7928ac: r0 = StackOverflowSharedWithoutFPURegs()
    //     0x7928ac: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0x7928b0: b               #0x792844
  }
  _ copyWithIndex(/* No info */) {
    // ** addr: 0xb36108, size: 0x168
    // 0xb36108: EnterFrame
    //     0xb36108: stp             fp, lr, [SP, #-0x10]!
    //     0xb3610c: mov             fp, SP
    // 0xb36110: AllocStack(0x30)
    //     0xb36110: sub             SP, SP, #0x30
    // 0xb36114: SetupParameters(dynamic _ /* r2 => r0, fp-0x8 */, dynamic _ /* d0 => d0, fp-0x20 */)
    //     0xb36114: mov             x0, x2
    //     0xb36118: stur            x2, [fp, #-8]
    //     0xb3611c: stur            d0, [fp, #-0x20]
    // 0xb36120: CheckStackOverflow
    //     0xb36120: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xb36124: cmp             SP, x16
    //     0xb36128: b.ls            #0xb36248
    // 0xb3612c: LoadField: r2 = r1->field_7
    //     0xb3612c: ldur            w2, [x1, #7]
    // 0xb36130: DecompressPointer r2
    //     0xb36130: add             x2, x2, HEAP, lsl #32
    // 0xb36134: mov             x1, x2
    // 0xb36138: r4 = const [0, 0x1, 0, 0x1, null]
    //     0xb36138: ldr             x4, [PP, #0x470]  ; [pp+0x470] List(5) [0, 0x1, 0, 0x1, Null]
    // 0xb3613c: r0 = toList()
    //     0xb3613c: bl              #0x9c165c  ; [dart:core] _Array::toList
    // 0xb36140: mov             x3, x0
    // 0xb36144: stur            x3, [fp, #-0x18]
    // 0xb36148: LoadField: r2 = r3->field_7
    //     0xb36148: ldur            w2, [x3, #7]
    // 0xb3614c: DecompressPointer r2
    //     0xb3614c: add             x2, x2, HEAP, lsl #32
    // 0xb36150: ldur            d0, [fp, #-0x20]
    // 0xb36154: r4 = inline_Allocate_Double()
    //     0xb36154: ldp             x4, x0, [THR, #0x60]  ; THR::top
    //     0xb36158: add             x4, x4, #0x10
    //     0xb3615c: cmp             x0, x4
    //     0xb36160: b.ls            #0xb36250
    //     0xb36164: str             x4, [THR, #0x60]  ; THR::top
    //     0xb36168: sub             x4, x4, #0xf
    //     0xb3616c: movz            x0, #0xe15c
    //     0xb36170: movk            x0, #0x3, lsl #16
    //     0xb36174: stur            x0, [x4, #-1]
    // 0xb36178: dmb             ishst
    // 0xb3617c: StoreField: r4->field_7 = d0
    //     0xb3617c: stur            d0, [x4, #7]
    // 0xb36180: mov             x0, x4
    // 0xb36184: stur            x4, [fp, #-0x10]
    // 0xb36188: r1 = Null
    //     0xb36188: mov             x1, NULL
    // 0xb3618c: cmp             w2, NULL
    // 0xb36190: b.eq            #0xb361b0
    // 0xb36194: ArrayLoad: r4 = r2[0]  ; List_4
    //     0xb36194: ldur            w4, [x2, #0x17]
    // 0xb36198: DecompressPointer r4
    //     0xb36198: add             x4, x4, HEAP, lsl #32
    // 0xb3619c: r8 = X0
    //     0xb3619c: ldr             x8, [PP, #0xd0]  ; [pp+0xd0] TypeParameter: X0
    // 0xb361a0: LoadField: r9 = r4->field_7
    //     0xb361a0: ldur            x9, [x4, #7]
    // 0xb361a4: r3 = Null
    //     0xb361a4: add             x3, PP, #0x5b, lsl #12  ; [pp+0x5b8b0] Null
    //     0xb361a8: ldr             x3, [x3, #0x8b0]
    // 0xb361ac: blr             x9
    // 0xb361b0: ldur            x2, [fp, #-0x18]
    // 0xb361b4: LoadField: r0 = r2->field_b
    //     0xb361b4: ldur            w0, [x2, #0xb]
    // 0xb361b8: r1 = LoadInt32Instr(r0)
    //     0xb361b8: sbfx            x1, x0, #1, #0x1f
    // 0xb361bc: mov             x0, x1
    // 0xb361c0: ldur            x1, [fp, #-8]
    // 0xb361c4: cmp             x1, x0
    // 0xb361c8: b.hs            #0xb3626c
    // 0xb361cc: LoadField: r1 = r2->field_f
    //     0xb361cc: ldur            w1, [x2, #0xf]
    // 0xb361d0: DecompressPointer r1
    //     0xb361d0: add             x1, x1, HEAP, lsl #32
    // 0xb361d4: ldur            x0, [fp, #-0x10]
    // 0xb361d8: ldur            x3, [fp, #-8]
    // 0xb361dc: ArrayStore: r1[r3] = r0  ; List_4
    //     0xb361dc: add             x25, x1, x3, lsl #2
    //     0xb361e0: add             x25, x25, #0xf
    //     0xb361e4: str             w0, [x25]
    //     0xb361e8: tbz             w0, #0, #0xb36204
    //     0xb361ec: ldurb           w16, [x1, #-1]
    //     0xb361f0: ldurb           w17, [x0, #-1]
    //     0xb361f4: and             x16, x17, x16, lsr #2
    //     0xb361f8: tst             x16, HEAP, lsr #32
    //     0xb361fc: b.eq            #0xb36204
    //     0xb36200: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xb36204: r16 = false
    //     0xb36204: add             x16, NULL, #0x30  ; false
    // 0xb36208: str             x16, [SP]
    // 0xb3620c: r1 = <double>
    //     0xb3620c: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0xb36210: r4 = const [0, 0x3, 0x1, 0x2, growable, 0x2, null]
    //     0xb36210: add             x4, PP, #8, lsl #12  ; [pp+0x8e60] List(7) [0, 0x3, 0x1, 0x2, "growable", 0x2, Null]
    //     0xb36214: ldr             x4, [x4, #0xe60]
    // 0xb36218: r0 = List.from()
    //     0xb36218: bl              #0x670c68  ; [dart:core] List::List.from
    // 0xb3621c: r16 = <double>
    //     0xb3621c: ldr             x16, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0xb36220: stp             x0, x16, [SP]
    // 0xb36224: r4 = const [0x1, 0x1, 0x1, 0x1, null]
    //     0xb36224: ldr             x4, [PP, #0x238]  ; [pp+0x238] List(5) [0x1, 0x1, 0x1, 0x1, Null]
    // 0xb36228: r0 = makeFixedListUnmodifiable()
    //     0xb36228: bl              #0x6c5914  ; [dart:_internal] ::makeFixedListUnmodifiable
    // 0xb3622c: stur            x0, [fp, #-0x10]
    // 0xb36230: r0 = EqData()
    //     0xb36230: bl              #0x6d8f60  ; AllocateEqDataStub -> EqData (size=0xc)
    // 0xb36234: ldur            x1, [fp, #-0x10]
    // 0xb36238: StoreField: r0->field_7 = r1
    //     0xb36238: stur            w1, [x0, #7]
    // 0xb3623c: LeaveFrame
    //     0xb3623c: mov             SP, fp
    //     0xb36240: ldp             fp, lr, [SP], #0x10
    // 0xb36244: ret
    //     0xb36244: ret             
    // 0xb36248: r0 = StackOverflowSharedWithFPURegs()
    //     0xb36248: bl              #0xf1ed48  ; StackOverflowSharedWithFPURegsStub
    // 0xb3624c: b               #0xb3612c
    // 0xb36250: SaveReg d0
    //     0xb36250: str             q0, [SP, #-0x10]!
    // 0xb36254: stp             x2, x3, [SP, #-0x10]!
    // 0xb36258: r0 = AllocateDouble()
    //     0xb36258: bl              #0xf1eb0c  ; AllocateDoubleStub
    // 0xb3625c: mov             x4, x0
    // 0xb36260: ldp             x2, x3, [SP], #0x10
    // 0xb36264: RestoreReg d0
    //     0xb36264: ldr             q0, [SP], #0x10
    // 0xb36268: b               #0xb3617c
    // 0xb3626c: r0 = RangeErrorSharedWithoutFPURegs()
    //     0xb3626c: bl              #0xf1f1f8  ; RangeErrorSharedWithoutFPURegsStub
  }
  static _ fromFormat(/* No info */) {
    // ** addr: 0xbb95a4, size: 0x210
    // 0xbb95a4: EnterFrame
    //     0xbb95a4: stp             fp, lr, [SP, #-0x10]!
    //     0xbb95a8: mov             fp, SP
    // 0xbb95ac: AllocStack(0x40)
    //     0xbb95ac: sub             SP, SP, #0x40
    // 0xbb95b0: SetupParameters(dynamic _ /* r1 => r0, fp-0x8 */)
    //     0xbb95b0: mov             x0, x1
    //     0xbb95b4: stur            x1, [fp, #-8]
    // 0xbb95b8: CheckStackOverflow
    //     0xbb95b8: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xbb95bc: cmp             SP, x16
    //     0xbb95c0: b.ls            #0xbb97a4
    // 0xbb95c4: r1 = <double>
    //     0xbb95c4: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0xbb95c8: r2 = 0
    //     0xbb95c8: movz            x2, #0
    // 0xbb95cc: r0 = _GrowableList()
    //     0xbb95cc: bl              #0x6003f4  ; [dart:core] _GrowableList::_GrowableList
    // 0xbb95d0: mov             x4, x0
    // 0xbb95d4: ldur            x0, [fp, #-8]
    // 0xbb95d8: stur            x4, [fp, #-0x28]
    // 0xbb95dc: LoadField: r1 = r0->field_7
    //     0xbb95dc: ldur            w1, [x0, #7]
    // 0xbb95e0: r5 = LoadInt32Instr(r1)
    //     0xbb95e0: sbfx            x5, x1, #1, #0x1f
    // 0xbb95e4: stur            x5, [fp, #-0x20]
    // 0xbb95e8: r6 = 0
    //     0xbb95e8: movz            x6, #0
    // 0xbb95ec: stur            x6, [fp, #-0x18]
    // 0xbb95f0: CheckStackOverflow
    //     0xbb95f0: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xbb95f4: cmp             SP, x16
    //     0xbb95f8: b.ls            #0xbb97ac
    // 0xbb95fc: cmp             x6, x5
    // 0xbb9600: b.ge            #0xbb9730
    // 0xbb9604: add             x7, x6, #2
    // 0xbb9608: stur            x7, [fp, #-0x10]
    // 0xbb960c: lsl             x2, x7, #1
    // 0xbb9610: mov             x1, x6
    // 0xbb9614: mov             x3, x5
    // 0xbb9618: r4 = const [0, 0x3, 0, 0x3, null]
    //     0xbb9618: ldr             x4, [PP, #0x600]  ; [pp+0x600] List(5) [0, 0x3, 0, 0x3, Null]
    // 0xbb961c: r0 = checkValidRange()
    //     0xbb961c: bl              #0x607704  ; [dart:core] RangeError::checkValidRange
    // 0xbb9620: ldur            x1, [fp, #-8]
    // 0xbb9624: ldur            x2, [fp, #-0x18]
    // 0xbb9628: mov             x3, x0
    // 0xbb962c: r0 = _substringUnchecked()
    //     0xbb962c: bl              #0x607618  ; [dart:core] _StringBase::_substringUnchecked
    // 0xbb9630: LoadField: r1 = r0->field_7
    //     0xbb9630: ldur            w1, [x0, #7]
    // 0xbb9634: cbz             w1, #0xbb9780
    // 0xbb9638: mov             x1, x0
    // 0xbb963c: r2 = 32
    //     0xbb963c: movz            x2, #0x20
    // 0xbb9640: r3 = Null
    //     0xbb9640: mov             x3, NULL
    // 0xbb9644: r0 = _parse()
    //     0xbb9644: bl              #0x612a0c  ; [dart:core] int::_parse
    // 0xbb9648: r1 = LoadInt32Instr(r0)
    //     0xbb9648: sbfx            x1, x0, #1, #0x1f
    //     0xbb964c: tbz             w0, #0, #0xbb9654
    //     0xbb9650: ldur            x1, [x0, #7]
    // 0xbb9654: and             w0, w1, #0x80
    // 0xbb9658: and             w2, w1, #0x7f
    // 0xbb965c: cbz             w0, #0xbb9674
    // 0xbb9660: mov             x0, x2
    // 0xbb9664: ubfx            x0, x0, #0, #0x20
    // 0xbb9668: neg             x1, x0
    // 0xbb966c: mov             x3, x1
    // 0xbb9670: b               #0xbb967c
    // 0xbb9674: ubfx            x2, x2, #0, #0x20
    // 0xbb9678: mov             x3, x2
    // 0xbb967c: ldur            x2, [fp, #-0x28]
    // 0xbb9680: r0 = BoxInt64Instr(r3)
    //     0xbb9680: sbfiz           x0, x3, #1, #0x1f
    //     0xbb9684: cmp             x3, x0, asr #1
    //     0xbb9688: b.eq            #0xbb9694
    //     0xbb968c: bl              #0xf1ee48  ; AllocateMintSharedWithoutFPURegsStub
    //     0xbb9690: stur            x3, [x0, #7]
    // 0xbb9694: stp             x0, NULL, [SP]
    // 0xbb9698: r0 = _Double.fromInteger()
    //     0xbb9698: bl              #0x61b204  ; [dart:core] _Double::_Double.fromInteger
    // 0xbb969c: mov             x2, x0
    // 0xbb96a0: ldur            x0, [fp, #-0x28]
    // 0xbb96a4: stur            x2, [fp, #-0x30]
    // 0xbb96a8: LoadField: r1 = r0->field_b
    //     0xbb96a8: ldur            w1, [x0, #0xb]
    // 0xbb96ac: LoadField: r3 = r0->field_f
    //     0xbb96ac: ldur            w3, [x0, #0xf]
    // 0xbb96b0: DecompressPointer r3
    //     0xbb96b0: add             x3, x3, HEAP, lsl #32
    // 0xbb96b4: LoadField: r4 = r3->field_b
    //     0xbb96b4: ldur            w4, [x3, #0xb]
    // 0xbb96b8: r3 = LoadInt32Instr(r1)
    //     0xbb96b8: sbfx            x3, x1, #1, #0x1f
    // 0xbb96bc: stur            x3, [fp, #-0x18]
    // 0xbb96c0: r1 = LoadInt32Instr(r4)
    //     0xbb96c0: sbfx            x1, x4, #1, #0x1f
    // 0xbb96c4: cmp             x3, x1
    // 0xbb96c8: b.ne            #0xbb96d4
    // 0xbb96cc: mov             x1, x0
    // 0xbb96d0: r0 = _growToNextCapacity()
    //     0xbb96d0: bl              #0x600108  ; [dart:core] _GrowableList::_growToNextCapacity
    // 0xbb96d4: ldur            x2, [fp, #-0x28]
    // 0xbb96d8: ldur            x3, [fp, #-0x18]
    // 0xbb96dc: add             x0, x3, #1
    // 0xbb96e0: lsl             x1, x0, #1
    // 0xbb96e4: StoreField: r2->field_b = r1
    //     0xbb96e4: stur            w1, [x2, #0xb]
    // 0xbb96e8: LoadField: r1 = r2->field_f
    //     0xbb96e8: ldur            w1, [x2, #0xf]
    // 0xbb96ec: DecompressPointer r1
    //     0xbb96ec: add             x1, x1, HEAP, lsl #32
    // 0xbb96f0: ldur            x0, [fp, #-0x30]
    // 0xbb96f4: ArrayStore: r1[r3] = r0  ; List_4
    //     0xbb96f4: add             x25, x1, x3, lsl #2
    //     0xbb96f8: add             x25, x25, #0xf
    //     0xbb96fc: str             w0, [x25]
    //     0xbb9700: tbz             w0, #0, #0xbb971c
    //     0xbb9704: ldurb           w16, [x1, #-1]
    //     0xbb9708: ldurb           w17, [x0, #-1]
    //     0xbb970c: and             x16, x17, x16, lsr #2
    //     0xbb9710: tst             x16, HEAP, lsr #32
    //     0xbb9714: b.eq            #0xbb971c
    //     0xbb9718: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xbb971c: ldur            x6, [fp, #-0x10]
    // 0xbb9720: ldur            x0, [fp, #-8]
    // 0xbb9724: mov             x4, x2
    // 0xbb9728: ldur            x5, [fp, #-0x20]
    // 0xbb972c: b               #0xbb95ec
    // 0xbb9730: mov             x2, x4
    // 0xbb9734: r16 = false
    //     0xbb9734: add             x16, NULL, #0x30  ; false
    // 0xbb9738: str             x16, [SP]
    // 0xbb973c: r1 = <double>
    //     0xbb973c: ldr             x1, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0xbb9740: r4 = const [0, 0x3, 0x1, 0x2, growable, 0x2, null]
    //     0xbb9740: add             x4, PP, #8, lsl #12  ; [pp+0x8e60] List(7) [0, 0x3, 0x1, 0x2, "growable", 0x2, Null]
    //     0xbb9744: ldr             x4, [x4, #0xe60]
    // 0xbb9748: r0 = List.from()
    //     0xbb9748: bl              #0x670c68  ; [dart:core] List::List.from
    // 0xbb974c: r16 = <double>
    //     0xbb974c: ldr             x16, [PP, #0x4298]  ; [pp+0x4298] TypeArguments: <double>
    // 0xbb9750: stp             x0, x16, [SP]
    // 0xbb9754: r4 = const [0x1, 0x1, 0x1, 0x1, null]
    //     0xbb9754: ldr             x4, [PP, #0x238]  ; [pp+0x238] List(5) [0x1, 0x1, 0x1, 0x1, Null]
    // 0xbb9758: r0 = makeFixedListUnmodifiable()
    //     0xbb9758: bl              #0x6c5914  ; [dart:_internal] ::makeFixedListUnmodifiable
    // 0xbb975c: stur            x0, [fp, #-8]
    // 0xbb9760: r0 = EqData()
    //     0xbb9760: bl              #0x6d8f60  ; AllocateEqDataStub -> EqData (size=0xc)
    // 0xbb9764: mov             x1, x0
    // 0xbb9768: ldur            x0, [fp, #-8]
    // 0xbb976c: StoreField: r1->field_7 = r0
    //     0xbb976c: stur            w0, [x1, #7]
    // 0xbb9770: mov             x0, x1
    // 0xbb9774: LeaveFrame
    //     0xbb9774: mov             SP, fp
    //     0xbb9778: ldp             fp, lr, [SP], #0x10
    // 0xbb977c: ret
    //     0xbb977c: ret             
    // 0xbb9780: mov             x2, x0
    // 0xbb9784: r1 = Null
    //     0xbb9784: mov             x1, NULL
    // 0xbb9788: r3 = 0
    //     0xbb9788: movz            x3, #0
    // 0xbb978c: r5 = 32
    //     0xbb978c: movz            x5, #0x20
    // 0xbb9790: r6 = Null
    //     0xbb9790: mov             x6, NULL
    // 0xbb9794: r0 = _handleFormatError()
    //     0xbb9794: bl              #0x613580  ; [dart:core] int::_handleFormatError
    // 0xbb9798: r0 = "Attempt to execute code removed by Dart AOT compiler (TFA)"
    //     0xbb9798: ldr             x0, [PP, #0x7e8]  ; [pp+0x7e8] "Attempt to execute code removed by Dart AOT compiler (TFA)"
    // 0xbb979c: r0 = Throw()
    //     0xbb979c: bl              #0xf1cdc0  ; ThrowStub
    // 0xbb97a0: brk             #0
    // 0xbb97a4: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xbb97a4: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xbb97a8: b               #0xbb95c4
    // 0xbb97ac: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xbb97ac: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xbb97b0: b               #0xbb95fc
  }
}

// class id: 418, size: 0x2c, field offset: 0x8
class RBatteryData extends Object {
}

// class id: 419, size: 0x8, field offset: 0x8
abstract class RReceiveHandler extends Object {

  get _ checkModuleList(/* No info */) {
    // ** addr: 0xd81554, size: 0x38
    // 0xd81554: EnterFrame
    //     0xd81554: stp             fp, lr, [SP, #-0x10]!
    //     0xd81558: mov             fp, SP
    // 0xd8155c: CheckStackOverflow
    //     0xd8155c: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xd81560: cmp             SP, x16
    //     0xd81564: b.ls            #0xd81584
    // 0xd81568: r1 = <RsCommonCommandEnum>
    //     0xd81568: add             x1, PP, #0x14, lsl #12  ; [pp+0x145d0] TypeArguments: <RsCommonCommandEnum>
    //     0xd8156c: ldr             x1, [x1, #0x5d0]
    // 0xd81570: r2 = 0
    //     0xd81570: movz            x2, #0
    // 0xd81574: r0 = _GrowableList()
    //     0xd81574: bl              #0x6003f4  ; [dart:core] _GrowableList::_GrowableList
    // 0xd81578: LeaveFrame
    //     0xd81578: mov             SP, fp
    //     0xd8157c: ldp             fp, lr, [SP], #0x10
    // 0xd81580: ret
    //     0xd81580: ret             
    // 0xd81584: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xd81584: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xd81588: b               #0xd81568
  }
}

// class id: 420, size: 0x8, field offset: 0x8
class RFunctionLostReceiveHandler extends RReceiveHandler {

  _ batteryDataReceived(/* No info */) {
    // ** addr: 0xef996c, size: 0x14
    // 0xef996c: EnterFrame
    //     0xef996c: stp             fp, lr, [SP, #-0x10]!
    //     0xef9970: mov             fp, SP
    // 0xef9974: r0 = RFunctionLostException()
    //     0xef9974: bl              #0xef9980  ; AllocateRFunctionLostExceptionStub -> RFunctionLostException (size=0x8)
    // 0xef9978: r0 = Throw()
    //     0xef9978: bl              #0xf1cdc0  ; ThrowStub
    // 0xef997c: brk             #0
  }
}

// class id: 434, size: 0x38, field offset: 0x8
//   const constructor, 
class RMicTimecodeData extends Object {

  get _ timecodeText(/* No info */) {
    // ** addr: 0xf00c38, size: 0x2a8
    // 0xf00c38: EnterFrame
    //     0xf00c38: stp             fp, lr, [SP, #-0x10]!
    //     0xf00c3c: mov             fp, SP
    // 0xf00c40: AllocStack(0x30)
    //     0xf00c40: sub             SP, SP, #0x30
    // 0xf00c44: CheckStackOverflow
    //     0xf00c44: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xf00c48: cmp             SP, x16
    //     0xf00c4c: b.ls            #0xf00ed8
    // 0xf00c50: LoadField: r0 = r1->field_27
    //     0xf00c50: ldur            w0, [x1, #0x27]
    // 0xf00c54: DecompressPointer r0
    //     0xf00c54: add             x0, x0, HEAP, lsl #32
    // 0xf00c58: cmp             w0, NULL
    // 0xf00c5c: b.eq            #0xf00ec8
    // 0xf00c60: LoadField: r2 = r1->field_2b
    //     0xf00c60: ldur            w2, [x1, #0x2b]
    // 0xf00c64: DecompressPointer r2
    //     0xf00c64: add             x2, x2, HEAP, lsl #32
    // 0xf00c68: stur            x2, [fp, #-0x18]
    // 0xf00c6c: cmp             w2, NULL
    // 0xf00c70: b.eq            #0xf00ec8
    // 0xf00c74: LoadField: r3 = r1->field_2f
    //     0xf00c74: ldur            w3, [x1, #0x2f]
    // 0xf00c78: DecompressPointer r3
    //     0xf00c78: add             x3, x3, HEAP, lsl #32
    // 0xf00c7c: stur            x3, [fp, #-0x10]
    // 0xf00c80: cmp             w3, NULL
    // 0xf00c84: b.eq            #0xf00ec8
    // 0xf00c88: LoadField: r4 = r1->field_33
    //     0xf00c88: ldur            w4, [x1, #0x33]
    // 0xf00c8c: DecompressPointer r4
    //     0xf00c8c: add             x4, x4, HEAP, lsl #32
    // 0xf00c90: stur            x4, [fp, #-8]
    // 0xf00c94: cmp             w4, NULL
    // 0xf00c98: b.eq            #0xf00ec8
    // 0xf00c9c: r1 = 60
    //     0xf00c9c: movz            x1, #0x3c
    // 0xf00ca0: branchIfSmi(r0, 0xf00cac)
    //     0xf00ca0: tbz             w0, #0, #0xf00cac
    // 0xf00ca4: r1 = LoadClassIdInstr(r0)
    //     0xf00ca4: ldur            x1, [x0, #-1]
    //     0xf00ca8: ubfx            x1, x1, #0xc, #0x14
    // 0xf00cac: str             x0, [SP]
    // 0xf00cb0: mov             x0, x1
    // 0xf00cb4: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0xf00cb4: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0xf00cb8: r0 = GDT[cid_x0 + 0x28cf]()
    //     0xf00cb8: movz            x17, #0x28cf
    //     0xf00cbc: add             lr, x0, x17
    //     0xf00cc0: ldr             lr, [x21, lr, lsl #3]
    //     0xf00cc4: blr             lr
    // 0xf00cc8: r1 = LoadClassIdInstr(r0)
    //     0xf00cc8: ldur            x1, [x0, #-1]
    //     0xf00ccc: ubfx            x1, x1, #0xc, #0x14
    // 0xf00cd0: mov             x16, x0
    // 0xf00cd4: mov             x0, x1
    // 0xf00cd8: mov             x1, x16
    // 0xf00cdc: r2 = 2
    //     0xf00cdc: movz            x2, #0x2
    // 0xf00ce0: r3 = "0"
    //     0xf00ce0: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf00ce4: r0 = GDT[cid_x0 + -0xffe]()
    //     0xf00ce4: sub             lr, x0, #0xffe
    //     0xf00ce8: ldr             lr, [x21, lr, lsl #3]
    //     0xf00cec: blr             lr
    // 0xf00cf0: r1 = Null
    //     0xf00cf0: mov             x1, NULL
    // 0xf00cf4: r2 = 14
    //     0xf00cf4: movz            x2, #0xe
    // 0xf00cf8: stur            x0, [fp, #-0x20]
    // 0xf00cfc: r0 = AllocateArray()
    //     0xf00cfc: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xf00d00: mov             x1, x0
    // 0xf00d04: ldur            x0, [fp, #-0x20]
    // 0xf00d08: stur            x1, [fp, #-0x28]
    // 0xf00d0c: StoreField: r1->field_f = r0
    //     0xf00d0c: stur            w0, [x1, #0xf]
    // 0xf00d10: r16 = ":"
    //     0xf00d10: ldr             x16, [PP, #0x728]  ; [pp+0x728] ":"
    // 0xf00d14: StoreField: r1->field_13 = r16
    //     0xf00d14: stur            w16, [x1, #0x13]
    // 0xf00d18: ldur            x0, [fp, #-0x18]
    // 0xf00d1c: r2 = 60
    //     0xf00d1c: movz            x2, #0x3c
    // 0xf00d20: branchIfSmi(r0, 0xf00d2c)
    //     0xf00d20: tbz             w0, #0, #0xf00d2c
    // 0xf00d24: r2 = LoadClassIdInstr(r0)
    //     0xf00d24: ldur            x2, [x0, #-1]
    //     0xf00d28: ubfx            x2, x2, #0xc, #0x14
    // 0xf00d2c: str             x0, [SP]
    // 0xf00d30: mov             x0, x2
    // 0xf00d34: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0xf00d34: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0xf00d38: r0 = GDT[cid_x0 + 0x28cf]()
    //     0xf00d38: movz            x17, #0x28cf
    //     0xf00d3c: add             lr, x0, x17
    //     0xf00d40: ldr             lr, [x21, lr, lsl #3]
    //     0xf00d44: blr             lr
    // 0xf00d48: r1 = LoadClassIdInstr(r0)
    //     0xf00d48: ldur            x1, [x0, #-1]
    //     0xf00d4c: ubfx            x1, x1, #0xc, #0x14
    // 0xf00d50: mov             x16, x0
    // 0xf00d54: mov             x0, x1
    // 0xf00d58: mov             x1, x16
    // 0xf00d5c: r2 = 2
    //     0xf00d5c: movz            x2, #0x2
    // 0xf00d60: r3 = "0"
    //     0xf00d60: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf00d64: r0 = GDT[cid_x0 + -0xffe]()
    //     0xf00d64: sub             lr, x0, #0xffe
    //     0xf00d68: ldr             lr, [x21, lr, lsl #3]
    //     0xf00d6c: blr             lr
    // 0xf00d70: ldur            x1, [fp, #-0x28]
    // 0xf00d74: ArrayStore: r1[2] = r0  ; List_4
    //     0xf00d74: add             x25, x1, #0x17
    //     0xf00d78: str             w0, [x25]
    //     0xf00d7c: tbz             w0, #0, #0xf00d98
    //     0xf00d80: ldurb           w16, [x1, #-1]
    //     0xf00d84: ldurb           w17, [x0, #-1]
    //     0xf00d88: and             x16, x17, x16, lsr #2
    //     0xf00d8c: tst             x16, HEAP, lsr #32
    //     0xf00d90: b.eq            #0xf00d98
    //     0xf00d94: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf00d98: ldur            x1, [fp, #-0x28]
    // 0xf00d9c: r16 = ":"
    //     0xf00d9c: ldr             x16, [PP, #0x728]  ; [pp+0x728] ":"
    // 0xf00da0: StoreField: r1->field_1b = r16
    //     0xf00da0: stur            w16, [x1, #0x1b]
    // 0xf00da4: ldur            x0, [fp, #-0x10]
    // 0xf00da8: r2 = 60
    //     0xf00da8: movz            x2, #0x3c
    // 0xf00dac: branchIfSmi(r0, 0xf00db8)
    //     0xf00dac: tbz             w0, #0, #0xf00db8
    // 0xf00db0: r2 = LoadClassIdInstr(r0)
    //     0xf00db0: ldur            x2, [x0, #-1]
    //     0xf00db4: ubfx            x2, x2, #0xc, #0x14
    // 0xf00db8: str             x0, [SP]
    // 0xf00dbc: mov             x0, x2
    // 0xf00dc0: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0xf00dc0: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0xf00dc4: r0 = GDT[cid_x0 + 0x28cf]()
    //     0xf00dc4: movz            x17, #0x28cf
    //     0xf00dc8: add             lr, x0, x17
    //     0xf00dcc: ldr             lr, [x21, lr, lsl #3]
    //     0xf00dd0: blr             lr
    // 0xf00dd4: r1 = LoadClassIdInstr(r0)
    //     0xf00dd4: ldur            x1, [x0, #-1]
    //     0xf00dd8: ubfx            x1, x1, #0xc, #0x14
    // 0xf00ddc: mov             x16, x0
    // 0xf00de0: mov             x0, x1
    // 0xf00de4: mov             x1, x16
    // 0xf00de8: r2 = 2
    //     0xf00de8: movz            x2, #0x2
    // 0xf00dec: r3 = "0"
    //     0xf00dec: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf00df0: r0 = GDT[cid_x0 + -0xffe]()
    //     0xf00df0: sub             lr, x0, #0xffe
    //     0xf00df4: ldr             lr, [x21, lr, lsl #3]
    //     0xf00df8: blr             lr
    // 0xf00dfc: ldur            x1, [fp, #-0x28]
    // 0xf00e00: ArrayStore: r1[4] = r0  ; List_4
    //     0xf00e00: add             x25, x1, #0x1f
    //     0xf00e04: str             w0, [x25]
    //     0xf00e08: tbz             w0, #0, #0xf00e24
    //     0xf00e0c: ldurb           w16, [x1, #-1]
    //     0xf00e10: ldurb           w17, [x0, #-1]
    //     0xf00e14: and             x16, x17, x16, lsr #2
    //     0xf00e18: tst             x16, HEAP, lsr #32
    //     0xf00e1c: b.eq            #0xf00e24
    //     0xf00e20: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf00e24: ldur            x1, [fp, #-0x28]
    // 0xf00e28: r16 = ":"
    //     0xf00e28: ldr             x16, [PP, #0x728]  ; [pp+0x728] ":"
    // 0xf00e2c: StoreField: r1->field_23 = r16
    //     0xf00e2c: stur            w16, [x1, #0x23]
    // 0xf00e30: ldur            x0, [fp, #-8]
    // 0xf00e34: r2 = 60
    //     0xf00e34: movz            x2, #0x3c
    // 0xf00e38: branchIfSmi(r0, 0xf00e44)
    //     0xf00e38: tbz             w0, #0, #0xf00e44
    // 0xf00e3c: r2 = LoadClassIdInstr(r0)
    //     0xf00e3c: ldur            x2, [x0, #-1]
    //     0xf00e40: ubfx            x2, x2, #0xc, #0x14
    // 0xf00e44: str             x0, [SP]
    // 0xf00e48: mov             x0, x2
    // 0xf00e4c: r4 = const [0, 0x1, 0x1, 0x1, null]
    //     0xf00e4c: ldr             x4, [PP, #0xe8]  ; [pp+0xe8] List(5) [0, 0x1, 0x1, 0x1, Null]
    // 0xf00e50: r0 = GDT[cid_x0 + 0x28cf]()
    //     0xf00e50: movz            x17, #0x28cf
    //     0xf00e54: add             lr, x0, x17
    //     0xf00e58: ldr             lr, [x21, lr, lsl #3]
    //     0xf00e5c: blr             lr
    // 0xf00e60: r1 = LoadClassIdInstr(r0)
    //     0xf00e60: ldur            x1, [x0, #-1]
    //     0xf00e64: ubfx            x1, x1, #0xc, #0x14
    // 0xf00e68: mov             x16, x0
    // 0xf00e6c: mov             x0, x1
    // 0xf00e70: mov             x1, x16
    // 0xf00e74: r2 = 2
    //     0xf00e74: movz            x2, #0x2
    // 0xf00e78: r3 = "0"
    //     0xf00e78: ldr             x3, [PP, #0x45f8]  ; [pp+0x45f8] "0"
    // 0xf00e7c: r0 = GDT[cid_x0 + -0xffe]()
    //     0xf00e7c: sub             lr, x0, #0xffe
    //     0xf00e80: ldr             lr, [x21, lr, lsl #3]
    //     0xf00e84: blr             lr
    // 0xf00e88: ldur            x1, [fp, #-0x28]
    // 0xf00e8c: ArrayStore: r1[6] = r0  ; List_4
    //     0xf00e8c: add             x25, x1, #0x27
    //     0xf00e90: str             w0, [x25]
    //     0xf00e94: tbz             w0, #0, #0xf00eb0
    //     0xf00e98: ldurb           w16, [x1, #-1]
    //     0xf00e9c: ldurb           w17, [x0, #-1]
    //     0xf00ea0: and             x16, x17, x16, lsr #2
    //     0xf00ea4: tst             x16, HEAP, lsr #32
    //     0xf00ea8: b.eq            #0xf00eb0
    //     0xf00eac: bl              #0xf1cde4  ; ArrayWriteBarrierStub
    // 0xf00eb0: ldur            x16, [fp, #-0x28]
    // 0xf00eb4: str             x16, [SP]
    // 0xf00eb8: r0 = _interpolate()
    //     0xf00eb8: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xf00ebc: LeaveFrame
    //     0xf00ebc: mov             SP, fp
    //     0xf00ec0: ldp             fp, lr, [SP], #0x10
    // 0xf00ec4: ret
    //     0xf00ec4: ret             
    // 0xf00ec8: r0 = ""
    //     0xf00ec8: ldr             x0, [PP, #0x1d8]  ; [pp+0x1d8] ""
    // 0xf00ecc: LeaveFrame
    //     0xf00ecc: mov             SP, fp
    //     0xf00ed0: ldp             fp, lr, [SP], #0x10
    // 0xf00ed4: ret
    //     0xf00ed4: ret             
    // 0xf00ed8: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xf00ed8: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xf00edc: b               #0xf00c50
  }
}

// class id: 435, size: 0x30, field offset: 0x8
//   const constructor, 
class RMicGainProfileData extends Object {
}

// class id: 436, size: 0x18, field offset: 0x8
//   const constructor, 
class RMicTxMacData extends Object {
}

// class id: 437, size: 0x30, field offset: 0x8
//   const constructor, 
class RMicTxStatusData extends Object {
}

// class id: 438, size: 0x30, field offset: 0x8
//   const constructor, 
class RMicMeterData extends Object {
}

// class id: 439, size: 0x38, field offset: 0x8
//   const constructor, 
class RMicBatteryData extends Object {
}

// class id: 440, size: 0x28, field offset: 0x8
//   const constructor, 
class RMicTfCardTimeData extends Object {
}

// class id: 441, size: 0x20, field offset: 0x8
//   const constructor, 
class RMicRemoteTargetData extends Object {
}

// class id: 442, size: 0x30, field offset: 0x8
//   const constructor, 
class RMicBasicInfoData extends Object {
}
