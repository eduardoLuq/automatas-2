/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTokenManager.java */
package  analizadorSintactico;
import simbolos.TablaDeSimbolos;
import simbolos.Variable;
import tiposDeDatos.TipoDeDato;
import tiposDeDatos.TiposDeDatos;
import java.io.InputStream;

/** Token Manager. */
public class AnalizadorSintacticoTokenManager implements AnalizadorSintacticoConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x900000L) != 0L)
            return 79;
         if ((active0 & 0x540L) != 0L)
         {
            jjmatchedKind = 29;
            return 26;
         }
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 29;
            return 8;
         }
         return -1;
      case 1:
         if ((active0 & 0x200L) != 0L)
            return 26;
         if ((active0 & 0x540L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 1;
            return 26;
         }
         return -1;
      case 2:
         if ((active0 & 0x540L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 2;
            return 26;
         }
         return -1;
      case 3:
         if ((active0 & 0x100L) != 0L)
            return 26;
         if ((active0 & 0x440L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 3;
            return 26;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjStartNfaWithStates_0(0, 23, 79);
      case 40:
         return jjStopAtPos(0, 11);
      case 41:
         return jjStopAtPos(0, 12);
      case 44:
         return jjStopAtPos(0, 16);
      case 45:
         return jjStopAtPos(0, 18);
      case 46:
         return jjStopAtPos(0, 17);
      case 59:
         return jjStopAtPos(0, 15);
      case 61:
         return jjStartNfaWithStates_0(0, 20, 79);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 123:
         return jjStopAtPos(0, 13);
      case 125:
         return jjStopAtPos(0, 14);
      default :
         return jjMoveNfa_0(6, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 102:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(1, 9, 26);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x500L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 26);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 26);
         break;
      case 115:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(4, 6, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 79;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 79:
                  if (curChar == 61)
                  {
                     if (kind > 21)
                        kind = 21;
                  }
                  if (curChar == 61)
                  {
                     if (kind > 19)
                        kind = 19;
                  }
                  break;
               case 8:
               case 26:
                  if ((0x3ff200000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(26);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                     jjCheckNAddStates(0, 5);
                  }
                  else if ((0x50008c0000000000L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(6, 9);
                  else if (curChar == 61)
                     jjCheckNAddTwoStates(46, 47);
                  else if (curChar == 33)
                     jjCheckNAddTwoStates(46, 47);
                  else if (curChar == 38)
                     jjAddStates(10, 11);
                  if ((0x8c0000000000L & l) != 0L)
                  {
                     if (kind > 22)
                        kind = 22;
                  }
                  else if ((0x5000000000000000L & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                  }
                  if (curChar == 60)
                     jjCheckNAddTwoStates(46, 47);
                  else if (curChar == 62)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 22:
                  if ((0x50008c0000000000L & l) != 0L && kind > 19)
                     kind = 19;
                  break;
               case 23:
                  if ((0x5000000000000000L & l) != 0L && kind > 21)
                     kind = 21;
                  break;
               case 24:
                  if ((0x8c0000000000L & l) != 0L && kind > 22)
                     kind = 22;
                  break;
               case 42:
                  if (curChar == 38)
                     jjAddStates(10, 11);
                  break;
               case 43:
                  if (curChar == 38 && kind > 19)
                     kind = 19;
                  break;
               case 44:
                  if (curChar == 38 && kind > 21)
                     kind = 21;
                  break;
               case 45:
                  if (curChar == 33)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 46:
                  if (curChar == 61 && kind > 19)
                     kind = 19;
                  break;
               case 47:
                  if (curChar == 61 && kind > 21)
                     kind = 21;
                  break;
               case 48:
                  if (curChar == 62)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 49:
                  if (curChar == 60)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 50:
                  if (curChar == 61)
                     jjCheckNAddTwoStates(46, 47);
                  break;
               case 51:
                  if (curChar == 34)
                     jjCheckNAddStates(6, 9);
                  break;
               case 52:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(52, 53);
                  break;
               case 53:
                  if (curChar == 34 && kind > 24)
                     kind = 24;
                  break;
               case 54:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(54, 55);
                  break;
               case 55:
                  if (curChar == 34 && kind > 27)
                     kind = 27;
                  break;
               case 70:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  jjCheckNAddStates(0, 5);
                  break;
               case 71:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(71, 72);
                  break;
               case 72:
                  if (curChar == 46)
                     jjCheckNAdd(73);
                  break;
               case 73:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  jjCheckNAdd(73);
                  break;
               case 74:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  jjCheckNAdd(74);
                  break;
               case 75:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 25)
                     kind = 25;
                  jjCheckNAdd(75);
                  break;
               case 76:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(76, 77);
                  break;
               case 77:
                  if (curChar == 46)
                     jjCheckNAdd(78);
                  break;
               case 78:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  jjCheckNAdd(78);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 8:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAdd(26);
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 6:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAdd(26);
                  }
                  else if (curChar == 124)
                     jjAddStates(12, 13);
                  if (curChar == 102)
                     jjAddStates(14, 15);
                  else if (curChar == 116)
                     jjAddStates(16, 17);
                  else if (curChar == 112)
                     jjAddStates(18, 19);
                  else if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 20;
                  else if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 14;
                  else if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 8;
                  else if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 0:
                  if (curChar == 110 && kind > 7)
                     kind = 7;
                  break;
               case 1:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 2:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 3:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 7:
                  if (curChar == 116 && kind > 7)
                     kind = 7;
                  break;
               case 9:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 101 && kind > 7)
                     kind = 7;
                  break;
               case 11:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 14:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 100)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 103 && kind > 7)
                     kind = 7;
                  break;
               case 17:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 18:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 19:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 25:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(26);
                  break;
               case 26:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(26);
                  break;
               case 27:
                  if (curChar == 112)
                     jjAddStates(18, 19);
                  break;
               case 28:
                  if (curChar == 101 && kind > 5)
                     kind = 5;
                  break;
               case 29:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 30:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 118)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 33:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 34:
                  if (curChar == 99 && kind > 5)
                     kind = 5;
                  break;
               case 35:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 36:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 35;
                  break;
               case 37:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 36;
                  break;
               case 38:
                  if (curChar == 117)
                     jjstateSet[jjnewStateCnt++] = 37;
                  break;
               case 39:
                  if (curChar == 124)
                     jjAddStates(12, 13);
                  break;
               case 40:
                  if (curChar == 124 && kind > 19)
                     kind = 19;
                  break;
               case 41:
                  if (curChar == 124 && kind > 21)
                     kind = 21;
                  break;
               case 52:
                  jjAddStates(20, 21);
                  break;
               case 54:
                  jjAddStates(22, 23);
                  break;
               case 56:
                  if (curChar == 116)
                     jjAddStates(16, 17);
                  break;
               case 57:
                  if (curChar == 101 && kind > 24)
                     kind = 24;
                  break;
               case 58:
                  if (curChar == 117)
                     jjCheckNAdd(57);
                  break;
               case 59:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 60:
                  if (curChar == 101 && kind > 26)
                     kind = 26;
                  break;
               case 61:
                  if (curChar == 117)
                     jjCheckNAdd(60);
                  break;
               case 62:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (curChar == 102)
                     jjAddStates(14, 15);
                  break;
               case 64:
                  if (curChar == 115)
                     jjCheckNAdd(57);
                  break;
               case 65:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 64;
                  break;
               case 66:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 65;
                  break;
               case 67:
                  if (curChar == 115)
                     jjCheckNAdd(60);
                  break;
               case 68:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 69:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 68;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 52:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(20, 21);
                  break;
               case 54:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(22, 23);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 79 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   71, 72, 74, 75, 76, 77, 52, 53, 54, 55, 43, 44, 40, 41, 66, 69, 
   59, 62, 33, 38, 52, 53, 54, 55, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\143\154\141\163\163", null, 
"\166\157\151\144", "\151\146", "\167\150\151\154\145", "\50", "\51", "\173", "\175", "\73", 
"\54", "\56", "\55", null, "\75", null, null, "\41", null, null, null, null, null, 
null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3fffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[79];
static private final int[] jjstateSet = new int[158];
static protected char curChar;
/** Constructor. */
public AnalizadorSintacticoTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public AnalizadorSintacticoTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 79; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
