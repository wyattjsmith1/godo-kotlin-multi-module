#ifndef KONAN_LIBGODOT_H
#define KONAN_LIBGODOT_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            libgodot_KBoolean;
#else
typedef _Bool           libgodot_KBoolean;
#endif
typedef unsigned short     libgodot_KChar;
typedef signed char        libgodot_KByte;
typedef short              libgodot_KShort;
typedef int                libgodot_KInt;
typedef long long          libgodot_KLong;
typedef unsigned char      libgodot_KUByte;
typedef unsigned short     libgodot_KUShort;
typedef unsigned int       libgodot_KUInt;
typedef unsigned long long libgodot_KULong;
typedef float              libgodot_KFloat;
typedef double             libgodot_KDouble;
typedef void*              libgodot_KNativePtr;
struct libgodot_KType;
typedef struct libgodot_KType libgodot_KType;

typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Byte;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Short;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Int;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Long;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Float;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Double;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Char;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Boolean;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_kotlin_Unit;
typedef struct {
  libgodot_KNativePtr pinned;
} libgodot_kref_godot_multimodule_TestNode;


typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(libgodot_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  libgodot_KBoolean (*IsInstance)(libgodot_KNativePtr ref, const libgodot_KType* type);
  libgodot_kref_kotlin_Byte (*createNullableByte)(libgodot_KByte);
  libgodot_kref_kotlin_Short (*createNullableShort)(libgodot_KShort);
  libgodot_kref_kotlin_Int (*createNullableInt)(libgodot_KInt);
  libgodot_kref_kotlin_Long (*createNullableLong)(libgodot_KLong);
  libgodot_kref_kotlin_Float (*createNullableFloat)(libgodot_KFloat);
  libgodot_kref_kotlin_Double (*createNullableDouble)(libgodot_KDouble);
  libgodot_kref_kotlin_Char (*createNullableChar)(libgodot_KChar);
  libgodot_kref_kotlin_Boolean (*createNullableBoolean)(libgodot_KBoolean);
  libgodot_kref_kotlin_Unit (*createNullableUnit)(void);

  /* User functions. */
  struct {
    struct {
      struct {
        struct {
          struct {
            libgodot_KType* (*_type)(void);
            libgodot_kref_godot_multimodule_TestNode (*TestNode)();
          } TestNode;
        } multimodule;
      } godot;
    } root;
  } kotlin;
} libgodot_ExportedSymbols;
extern libgodot_ExportedSymbols* libgodot_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIBGODOT_H */
