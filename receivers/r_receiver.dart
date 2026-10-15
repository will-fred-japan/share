// lib: , url: package:roselink_bluetooth/commander/receiver/r_receiver.dart

// class id: 1050400, size: 0x8
class :: {
}

// class id: 443, size: 0xc, field offset: 0x8
abstract class RReceiver extends Object {

  late RReceiveHandler receiveHandler; // offset: 0x8
}

// class id: 447, size: 0xc, field offset: 0xc
class RReceiverEmpty extends RReceiver {

  _ process(/* No info */) {
    // ** addr: 0xefbe18, size: 0x90
    // 0xefbe18: EnterFrame
    //     0xefbe18: stp             fp, lr, [SP, #-0x10]!
    //     0xefbe1c: mov             fp, SP
    // 0xefbe20: AllocStack(0x18)
    //     0xefbe20: sub             SP, SP, #0x18
    // 0xefbe24: SetupParameters(dynamic _ /* r2 => r2, fp-0x8 */)
    //     0xefbe24: stur            x2, [fp, #-8]
    // 0xefbe28: CheckStackOverflow
    //     0xefbe28: ldr             x16, [THR, #0x48]  ; THR::stack_limit
    //     0xefbe2c: cmp             SP, x16
    //     0xefbe30: b.ls            #0xefbea0
    // 0xefbe34: r0 = LoadStaticField(0x804)
    //     0xefbe34: ldr             x0, [THR, #0x78]  ; THR::field_table_values
    //     0xefbe38: ldr             x0, [x0, #0x1008]
    // 0xefbe3c: ldr             x16, [THR, #0x90]  ; THR::object_sentinel
    // 0xefbe40: cmp             w0, w16
    // 0xefbe44: b.ne            #0xefbe50
    // 0xefbe48: r2 = rsbt
    //     0xefbe48: ldr             x2, [PP, #0x7d58]  ; [pp+0x7d58] Field <::.rsbt>: static late final (offset: 0x804)
    // 0xefbe4c: r0 = InitLateFinalStaticField()
    //     0xefbe4c: bl              #0xf1cc80  ; InitLateFinalStaticFieldStub
    // 0xefbe50: LoadField: r3 = r0->field_1f
    //     0xefbe50: ldur            w3, [x0, #0x1f]
    // 0xefbe54: DecompressPointer r3
    //     0xefbe54: add             x3, x3, HEAP, lsl #32
    // 0xefbe58: stur            x3, [fp, #-0x10]
    // 0xefbe5c: r1 = Null
    //     0xefbe5c: mov             x1, NULL
    // 0xefbe60: r2 = 4
    //     0xefbe60: movz            x2, #0x4
    // 0xefbe64: r0 = AllocateArray()
    //     0xefbe64: bl              #0xf1ebbc  ; AllocateArrayStub
    // 0xefbe68: r16 = "[commander] [receive] "
    //     0xefbe68: add             x16, PP, #0x13, lsl #12  ; [pp+0x13760] "[commander] [receive] "
    //     0xefbe6c: ldr             x16, [x16, #0x760]
    // 0xefbe70: StoreField: r0->field_f = r16
    //     0xefbe70: stur            w16, [x0, #0xf]
    // 0xefbe74: ldur            x1, [fp, #-8]
    // 0xefbe78: StoreField: r0->field_13 = r1
    //     0xefbe78: stur            w1, [x0, #0x13]
    // 0xefbe7c: str             x0, [SP]
    // 0xefbe80: r0 = _interpolate()
    //     0xefbe80: bl              #0x6052dc  ; [dart:core] _StringBase::_interpolate
    // 0xefbe84: ldur            x1, [fp, #-0x10]
    // 0xefbe88: mov             x2, x0
    // 0xefbe8c: r0 = i()
    //     0xefbe8c: bl              #0x6e0880  ; [package:logger/src/logger.dart] Logger::i
    // 0xefbe90: r0 = Null
    //     0xefbe90: mov             x0, NULL
    // 0xefbe94: LeaveFrame
    //     0xefbe94: mov             SP, fp
    //     0xefbe98: ldp             fp, lr, [SP], #0x10
    // 0xefbe9c: ret
    //     0xefbe9c: ret             
    // 0xefbea0: r0 = StackOverflowSharedWithoutFPURegs()
    //     0xefbea0: bl              #0xf1ecc8  ; StackOverflowSharedWithoutFPURegsStub
    // 0xefbea4: b               #0xefbe34
  }
}
